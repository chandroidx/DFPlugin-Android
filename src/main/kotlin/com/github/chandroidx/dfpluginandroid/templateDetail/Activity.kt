package com.github.chandroidx.dfpluginandroid.templateDetail

fun createActivity(
        packageName: String,
        className: String,
): String {
    val bindingName = "Activity${className}Binding"
    val viewModelName = "${className}ViewModel"

    return """package ${packageName}.view

import ai.deepfine.presentation.base.BaseActivity
import ${packageName}.databinding.${bindingName}
import ${packageName}.viewModel.${viewModelName}
import android.view.LayoutInflater
import android.content.Context
import android.content.Intent
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ${className}Activity : BaseActivity<${bindingName}, ${viewModelName}>() {
  override val bindFactory: (LayoutInflater) -> ${bindingName} = ${bindingName}::inflate
  override val viewModel: ${viewModelName} by viewModels()
  
  //================================================================================================
  // Initialize
  //================================================================================================
  override fun onBind() {
  }
  
  override fun initView() {
  }
  
  //================================================================================================
  // Companion
  //================================================================================================
  companion object {
    fun newInstance(context: Context) = Intent(context, ${className}Activity::class.java)
  }
}
""".trimIndent()
}