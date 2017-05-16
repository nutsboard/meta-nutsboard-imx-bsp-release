# Copyright (C) 2012-2016 Freescale Semiconductor
# Copyright (C) 2012-2014 O.S. Systems Software LTDA.
# Copyright 2017 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

require recipes-graphics/xorg-driver/xf86-video-imxfb-vivante.inc

SRCBRANCH = "imx_exa_viv6_g2d"
S = "${WORKDIR}/git/"
XF86_VIDEO_IMXFB_VIV_SRC ?= "git://git.freescale.com/imx/xf86-imxfb-vivante.git;protocol=git"
SRC_URI = "${XF86_VIDEO_IMXFB_VIV_SRC};branch=${SRCBRANCH}"
SRC_URI +="file://rc.autohdmi"
SRCREV = "a508a7864fb149b7db9d77c279f7076f39521248"

DEPENDS += "virtual/libg2d"

RDEPENDS_${PN}_remove = "libvivante-dri-mx6"

RDEPENDS_${PN}_append = " libvivante-dri-imx"

COMPATIBLE_MACHINE = "(mx6|mx8|mx7ulp)"