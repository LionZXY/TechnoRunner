.global _pkg_jre
.global _pkg_jre_end
.global _pkg_jrepathtxt
.global _pkg_jrepathtxt_end
.global _pkg_runner
.global _pkg_runner_end


.data

_pkg_jre:
.incbin linux/links/jre.tar.gz

_pkg_jre_end:
.byte 0

_pkg_jrepathtxt:
.incbin linux/links/jrepath.txt

_pkg_jrepathtxt_end:
.byte 0

_pkg_runner:
.incbin linux/links/runner.jar

_pkg_runner_end:
.byte 0