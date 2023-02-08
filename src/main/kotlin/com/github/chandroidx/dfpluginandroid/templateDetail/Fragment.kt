package com.github.chandroidx.dfpluginandroid.templateDetail

fun createFragment(
        packageName: String,
        className: String,
): String {
    val bindingName = "Fragment${className}Binding"
    val viewModelName = "${className}ViewModel"

    return """package ${packageName}.view

import ai.deepfine.presentation.base.BaseFragment
import ${packageName}.databinding.${bindingName}
import ${packageName}.viewmodel.${viewModelName}
import android.view.LayoutInflater
import android.content.Context
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ${className}Fragment : BaseFragment<${bindingName}, ${viewModelName}>() {
  override val bindFactory: (LayoutInflater, ViewGroup?, Boolean) -> ${bindingName} = ${bindingName}::inflate
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
    fun newInstance() = ${className}Fragment()
  }
}
""".trimIndent()
}