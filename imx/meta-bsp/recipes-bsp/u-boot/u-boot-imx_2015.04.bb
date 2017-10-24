# Copyright (C) 2013-2016 Freescale Semiconductor
# Copyright 2017 NXP
# Copyright 2017 NutsBoard.Org

DESCRIPTION = "NutsBoard U-Boot suppporting Pistachio series."

require recipes-bsp/u-boot/u-boot.inc
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=c7383a594871c03da76b3707929d2919"

PROVIDES += "u-boot"

SRCBRANCH = "nutsboard_N7.1.1_2.0.0-ga"
SRCREV = "fd95df7ebda7ce4b81a33541958574d9ead71603"
SRC_URI = "git://github.com/pistacho-android-7/uboot-imx.git;branch=${SRCBRANCH} \
           "

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(mx6)"
