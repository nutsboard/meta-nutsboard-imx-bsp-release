# Copyright (C) 2016 Freescale Semiconductor
# Copyright 2017 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "GPU G2D library and apps for imx6"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://COPYING;md5=6b552f505eedab4a11ab538cf3db743a"

PROVIDES += "virtual/libg2d"

SRC_URI = "${FSL_MIRROR}/${PN}-${PV}.bin;fsl-eula=true"

S="${WORKDIR}/${PN}-${PV}"

inherit fsl-eula-unpack

SRC_URI[md5sum] = "a2e6df7a5f86586b0e91258ac545ed68"
SRC_URI[sha256sum] = "738e5d367f0e0f13e4b5d46a5889187b0a1c01db308982cbd7a39bd5072e95e5"

do_install () {

    install -d ${D}${libdir}
    install -d ${D}${includedir}

    cp ${S}/g2d/usr/lib/*.so* ${D}${libdir}
    cp -Pr ${S}/g2d/usr/include/* ${D}${includedir}
    cp -r ${S}/gpu-demos/opt ${D}
}

RDEPENDS_${PN} = "libgal-imx"

FILES_${PN} = "${libdir}/libg2d* /opt"
FILES_${PN}-dev = "${includedir}"
INSANE_SKIP_${PN} = "ldflags"

COMPATIBLE_MACHINE = "(mx6|mx7ulp)"