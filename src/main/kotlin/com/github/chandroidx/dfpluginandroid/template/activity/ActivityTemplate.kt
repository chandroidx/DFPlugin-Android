package com.github.chandroidx.dfpluginandroid.template.activity

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.defaultPackageNameParameter

val activityTemplate
    get() = template {
        name = "DeepFine Activity Template"
        description = "Creates new Activity/ViewModel with layout"
        minApi = 16
        category = Category.Other
        formFactor = FormFactor.Mobile
        screens = listOf(
                WizardUiContext.FragmentGallery, WizardUiContext.MenuEntry,
                WizardUiContext.NewProject, WizardUiContext.NewModule
        )

        val packageName = defaultPackageNameParameter
        val className = stringParameter {
            name = "Name"
            default = "Sample"
            help = "Layer Name"
            constraints = listOf(Constraint.NONEMPTY)
        }

        widgets(
                TextFieldWidget(className),
                PackageNameWidget(packageName)
        )

        recipe = { data: TemplateData ->
            activityRecipe(
                    data as ModuleTemplateData,
                    packageName.value,
                    className.value,
            )
        }
    }