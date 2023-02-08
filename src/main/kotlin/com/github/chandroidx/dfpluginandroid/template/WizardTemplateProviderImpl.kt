package com.github.chandroidx.dfpluginandroid.template

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import com.github.chandroidx.dfpluginandroid.template.activity.activityTemplate
import com.github.chandroidx.dfpluginandroid.template.dialogFragment.dialogFragmentTemplate
import com.github.chandroidx.dfpluginandroid.template.fragment.fragmentTemplate

class WizardTemplateProviderImpl : WizardTemplateProvider() {
    override fun getTemplates(): List<Template> = listOf(activityTemplate, fragmentTemplate, dialogFragmentTemplate)
}