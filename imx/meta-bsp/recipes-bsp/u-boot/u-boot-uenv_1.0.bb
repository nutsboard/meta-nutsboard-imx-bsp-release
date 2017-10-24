SUMMARY = "u-boot uEnv.txt"
DESCRIPTION = "u-boot uEnv.txt"
SECTION = "base"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://README;md5=b46d1b9d738194641a27c9563f2ad76c"

SRC_URI += " \
   file://uEnv.txt \
   file://README \
"
S = "${WORKDIR}"

inherit deploy

do_deploy() {
	install -d ${DEPLOYDIR}
	install ${S}/uEnv.txt ${DEPLOYDIR}/uEnv.txt
}

addtask deploy after do_install before do_build

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(mx6)"
