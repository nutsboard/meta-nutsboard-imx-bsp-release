# Copyright (C) 2015-2016 Freescale Semiconductor

SUMMARY = "Kernel loadable module for Vivante GPU"
DESCRIPTION = "Builds the Vivante GPU kernel driver as a loadable kernel module, \
allowing flexibility to use an older kernel with a newer graphics release."
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=12f884d2ae1ff87c09e5b7ccc2c4ca7e"

SRC_URI = "${FSL_MIRROR}/${PN}-${PV}.tar.gz \
           file://kbuild.patch"
SRC_URI[md5sum] = "f7d52677fa4fbff25fd99e263a0470c2"
SRC_URI[sha256sum] = "934e46d1b2112296f93dffe6caa465fa30caa85a202f664feb6b570e78e7afbc"

inherit module

KERNEL_MODULE_AUTOLOAD = "galcore"