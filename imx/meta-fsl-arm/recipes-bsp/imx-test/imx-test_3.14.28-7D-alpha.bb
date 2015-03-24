# Copyright (C) 2013-2015 Freescale Semiconductor

include recipes-bsp/imx-test/imx-test.inc

DEPENDS_mx6sx = "virtual/kernel imx-lib"

SRC_URI_append_mx5 = " file://clocks.sh"
SRC_URI_append_mxs = " file://clocks.sh"

SRC_URI[md5sum] = "f349aed49830a21cc75d305b06979205"
SRC_URI[sha256sum] = "ea3d572e82a374bcfc9acc654b66262cd97a246ffec9fb9fc458b19a02512723"

COMPATIBLE_MACHINE = "(mxs|mx5|mx6|mx7)"