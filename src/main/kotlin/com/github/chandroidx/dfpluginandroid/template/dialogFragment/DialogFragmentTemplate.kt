package com.github.chandroidx.dfpluginandroid.template.dialogFragment

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.defaultPackageNameParameter

val dialogFragmentTemplate
    get() = template {
        name = "DeepFine DialogFragment Template"
        description = "Creates new DialogFragment/ViewModel with layout"
        minApi = 16
        category = Category.Other
        formFactor = FormFactor.Mobile
        screens = listOf(
                WizardUiContext.FragmentGallery, WizardUiContext.MenuEntry,
                WizardUiContext.NewProject, WizardUiContext.NewModule
        )

        val packageName = defaultPackageNameParameter
        val className = stringParameter {
            name = "Template"
            default = "Sample"
            help = "Template Name"
            constraints = listOf(Constraint.NONEMPTY)
        }

        widgets(
                TextFieldWidget(className),
                PackageNameWidget(packageName)
        )

        recipe = { data: TemplateData ->
            dialogFragmentRecipe(
                    data as ModuleTemplateData,
                    packageName.value,
                    className.value,
            )
        }
    }