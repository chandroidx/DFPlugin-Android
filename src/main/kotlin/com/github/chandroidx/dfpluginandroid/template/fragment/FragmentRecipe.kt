package com.github.chandroidx.dfpluginandroid.template.fragment

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.github.chandroidx.dfpluginandroid.templateDetail.createFragment
import com.github.chandroidx.dfpluginandroid.templateDetail.createLayout
import com.github.chandroidx.dfpluginandroid.templateDetail.createViewModel

fun RecipeExecutor.fragmentRecipe(
        moduleData: ModuleTemplateData,
        packageName: String,
        className: String,
) {
    val (_, srcOut, resOut) = moduleData

    save(
            createFragment(packageName, className),
            srcOut.resolve("view/${className}Fragment.kt")
    )

    save(
            createLayout(),
            resOut.resolve("layout/fragment_${className.lowercase()}.xml")
    )

    save(
            createViewModel(packageName, className),
            srcOut.resolve("viewModel/${className}ViewModel.kt")
    )
}