# Copyright 2017 NutsBoard.Org
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Linux Kernel provided and supported by NXP"
DESCRIPTION = "Linux Kernel provided and supported by NXP with focus on \
NutsBoard Pistachio SBC. It includes support for many IPs such as GPU, VPU and IPU."

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "nutsboard_nxp_4.9.11_1.0.0_ga-wip"
KERNEL_SRC ?= "git://github.com/nutsboard/linux-imx.git;protocol=git"
SRC_URI = "${KERNEL_SRC};branch=${SRCBRANCH}"
SRCREV = "7fdf2e63b6218da9ea7ec831964f609beabf26bf"

DEFAULT_PREFERENCE = "1"

DO_CONFIG_V7_COPY = "no"
DO_CONFIG_V7_COPY_mx6 = "yes"
DO_CONFIG_V7_COPY_mx7 = "yes"

addtask copy_defconfig after do_unpack before do_preconfigure
do_copy_defconfig () {
    install -d ${B}
    if [ ${DO_CONFIG_V7_COPY} = "yes" ]; then
        # copy latest imx_v7_defconfig to use for mx6, mx6ul and mx7
        mkdir -p ${B}
        cp ${S}/arch/arm/configs/nutsboard_imx_defconfig ${B}/.config
        cp ${S}/arch/arm/configs/nutsboard_imx_defconfig ${B}/../defconfig
    fi
}

COMPATIBLE_MACHINE = "(mx6)"
EXTRA_OEMAKE_append_mx6 = " ARCH=arm"
