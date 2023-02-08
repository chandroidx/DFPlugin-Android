package com.github.chandroidx.dfpluginandroid.template

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.github.chandroidx.dfpluginandroid.templateDetail.createActivity
import com.github.chandroidx.dfpluginandroid.templateDetail.createLayout
import com.github.chandroidx.dfpluginandroid.templateDetail.createViewModel

fun RecipeExecutor.activitySetup(
        moduleData: ModuleTemplateData,
        packageName: String,
        className: String,
) {
    val (_, srcOut, resOut) = moduleData

    save(
            createActivity(packageName, className),
            srcOut.resolve("view/${className}Activity.kt")
    )

    save(
            createLayout(),
            resOut.resolve("layout/activity_${className.lowercase()}.xml")
    )

    save(
            createViewModel(packageName, className),
            srcOut.resolve("viewModel/${className}ViewModel.kt")
    )
}