package com.ss.android.ugc.bytex.gradletoolkit

import com.android.build.gradle.internal.scope.VariantScope
import com.ss.android.ugc.bytex.compat.gradleapiv3_0.VariantScopeV30
import com.ss.android.ugc.bytex.compat.gradleapiv3_2.VariantScopeV32
import com.ss.android.ugc.bytex.compat.gradleapiv3_3.VariantScopeV33
import java.io.File

private val ALL_ARTIFACTS_GETTER =
        when {
            GTE_V33 -> VariantScopeV33::getAllArtifacts
            GTE_V32 -> VariantScopeV32::getAllArtifacts
            else -> VariantScopeV30::getAllArtifacts
        }

private val ALL_CLASSES_GETTER =
        when {
            GTE_V33 -> VariantScopeV33::getAllClasses
            GTE_V32 -> VariantScopeV32::getAllClasses
            else -> VariantScopeV30::getAllClasses
        }

private val APK_GETTER =
        when {
            GTE_V33 -> VariantScopeV33::getApk
            GTE_V32 -> VariantScopeV32::getApk
            else -> VariantScopeV30::getApk
        }

private val JAVAC_GETTER =
        when {
            GTE_V33 -> VariantScopeV33::getJavac
            GTE_V32 -> VariantScopeV32::getJavac
            else -> VariantScopeV30::getJavac
        }

private val MERGED_ASSETS_GETTER =
        when {
            GTE_V33 -> VariantScopeV33::getMergedAssets
            GTE_V32 -> VariantScopeV32::getMergedAssets
            else -> VariantScopeV30::getMergedAssets
        }

private val MERGED_MANIFESTS_GETTER =
        when {
            GTE_V33 -> VariantScopeV33::getMergedManifests
            GTE_V32 -> VariantScopeV32::getMergedManifests
            else -> VariantScopeV30::getMergedManifests
        }

private val MERGED_RESOURCE_GETTER =
        when {
            GTE_V33 -> VariantScopeV33::getMergedRes
            GTE_V32 -> VariantScopeV32::getMergedRes
            else -> VariantScopeV30::getMergedRes
        }

private val PROCESSED_RES_GETTER =
        when {
            GTE_V33 -> VariantScopeV33::getProcessedRes
            GTE_V32 -> VariantScopeV32::getProcessedRes
            else -> VariantScopeV30::getProcessedRes
        }

private val SYMBOL_LIST_GETTER =
        when {
            GTE_V33 -> VariantScopeV33::getSymbolList
            GTE_V32 -> VariantScopeV32::getSymbolList
            else -> VariantScopeV30::getSymbolList
        }

private val SYMBOL_LIST_WITH_PACKAGE_NAME_GETTER =
        when {
            GTE_V33 -> VariantScopeV33::getSymbolListWithPackageName
            GTE_V32 -> VariantScopeV32::getSymbolListWithPackageName
            else -> VariantScopeV30::getSymbolListWithPackageName
        }

/**
 * The output directory of APK files
 */
val VariantScope.apk: Collection<File>
    get() = APK_GETTER(this)

val VariantScope.javac: Collection<File>
    get() = JAVAC_GETTER(this)

/**
 * The output directory of merged [AndroidManifest.xml](https://developer.android.com/guide/topics/manifest/manifest-intro)
 */
val VariantScope.mergedManifests: Collection<File>
    get() = MERGED_MANIFESTS_GETTER(this)

/**
 * The output directory of merged resources
 */
val VariantScope.mergedRes: Collection<File>
    get() = MERGED_RESOURCE_GETTER(this)

/**
 * The output directory of merged assets
 */
val VariantScope.mergedAssets: Collection<File>
    get() = MERGED_ASSETS_GETTER(this)

/**
 * The output directory of processed resources: *resources-**variant**.ap\_*
 */
val VariantScope.processedRes: Collection<File>
    get() = PROCESSED_RES_GETTER(this)

/**
 * All of classes
 */
val VariantScope.allClasses: Collection<File>
    get() = ALL_CLASSES_GETTER(this)

val VariantScope.symbolList: Collection<File>
    get() = SYMBOL_LIST_GETTER(this)

val VariantScope.symbolListWithPackageName: Collection<File>
    get() = SYMBOL_LIST_WITH_PACKAGE_NAME_GETTER(this)

val VariantScope.allArtifacts: Map<String, Collection<File>>
    get() = ALL_ARTIFACTS_GETTER(this)
