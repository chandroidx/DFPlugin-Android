package com.github.chandroidx.dfpluginandroid.template.fragment

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.defaultPackageNameParameter

val fragmentTemplate
    get() = template {
        name = "DeepFine Fragment Template"
        description = "Creates new Fragment/ViewModel with layout"
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
            fragmentRecipe(
                    data as ModuleTemplateData,
                    packageName.value,
                    className.value,
            )
        }
    }