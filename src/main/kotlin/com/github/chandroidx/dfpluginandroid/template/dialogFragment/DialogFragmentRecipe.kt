package com.github.chandroidx.dfpluginandroid.template.dialogFragment

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.github.chandroidx.dfpluginandroid.templateDetail.createActivity
import com.github.chandroidx.dfpluginandroid.templateDetail.createDialogFragment
import com.github.chandroidx.dfpluginandroid.templateDetail.createLayout
import com.github.chandroidx.dfpluginandroid.templateDetail.createViewModel

fun RecipeExecutor.dialogFragmentRecipe(
        moduleData: ModuleTemplateData,
        packageName: String,
        className: String,
) {
    val (_, srcOut, resOut) = moduleData

    save(
            createDialogFragment(packageName, className),
            srcOut.resolve("view/${className}DialogFragment.kt")
    )

    save(
            createLayout(),
            resOut.resolve("layout/dialog_fragment_${className.lowercase()}.xml")
    )

    save(
            createViewModel(packageName, className),
            srcOut.resolve("viewModel/${className}ViewModel.kt")
    )
}