package ru.glitchless.games.tprunner.download

import nu.redpois0n.oslib.OperatingSystem
import sk.tomsik68.mclauncher.api.ui.IProgressMonitor
import ru.glitchless.games.tprunner.utils.DirectoryHelper
import java.io.File

fun checkAndDownloadAll(monitor: IProgressMonitor) {
    val os = OperatingSystem.getOperatingSystem()
    println("Init download for ${os.type} ${os.arch}")

    val jre = DirectoryHelper.getJREPathFile()
    if (!jre.exists() || jre.readText().isEmpty() || !File(jre.readText()).exists()) {
        val javaDownloader = JavaDownloader()
        javaDownloader.initDownloader()
        javaDownloader.downloadJava(monitor)?.let {
            DirectoryHelper.writeJREPath(it.absolutePath)
        }
    }

    val launcherDownloader = LauncherDownloader()
    launcherDownloader.initDownloader()
    if (!launcherDownloader.checkFile()) {
        launcherDownloader.updateLauncher(monitor)
    }
}
