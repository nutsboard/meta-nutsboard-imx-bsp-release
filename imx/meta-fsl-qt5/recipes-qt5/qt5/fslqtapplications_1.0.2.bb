# Copyright (C) 2014-2015 Freescale Semiconductor
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Freescale QT Multimedia applications"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://COPYING;md5=acdb807ac7275fe32f9f64992e111241"

inherit fsl-eula-unpack autotools pkgconfig

# base on QtMultimedia v5.2.1
DEPENDS += "qtmultimedia gstreamer1.0 gstreamer1.0-plugins-base"

SRC_URI = "${FSL_MIRROR}/${PN}-${PV}.bin;fsl-eula=true \
           file://qtimxplayer.desktop \
"
SRC_URI[md5sum] = "5fe13a1d91f61313be0f38b951e61987"
SRC_URI[sha256sum] = "e3461acea78d2f22598337439f4e51a2cc5bb4f640520db2de1e0c61a541bd5a"

do_install () {
    install -d ${D}${datadir}/applications
    install -m 0644 ${WORKDIR}/qtimxplayer.desktop ${D}${datadir}/applications
    install -d ${D}${datadir}/qt5
    cp -r ${S}/usr/share/qt5/examples ${D}${datadir}/qt5
    install -d ${D}${datadir}/pixmaps
    cp -r ${S}/usr/share/pixmaps/* ${D}${datadir}/pixmaps
}

FILES_${PN} = " \
    ${datadir}/qt5/examples/*/* \
    ${datadir}/applications/* \
    ${datadir}/pixmaps/* \
"

INSANE_SKIP_${PN} += "debug-files"


