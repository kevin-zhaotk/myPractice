#!/bin/sh

../android-sdk-linux/tools/android create project \
--target 10 \
--name layout_test \
--path ./layout_test \
--activity layoutActivity \
--package com.example.layout
