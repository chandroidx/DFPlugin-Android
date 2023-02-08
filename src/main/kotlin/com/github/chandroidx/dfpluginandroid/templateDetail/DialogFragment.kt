package com.github.chandroidx.dfpluginandroid.templateDetail

fun createDialogFragment(
        packageName: String,
        className: String,
): String {
    val bindingName = "DialogFragment${className}Binding"
    val viewModelName = "${className}ViewModel"

    return """package ${packageName}.view

import ai.deepfine.presentation.base.BaseDialogFragment
import ${packageName}.databinding.${bindingName}
import ${packageName}.viewmodel.${viewModelName}
import android.view.LayoutInflater
import android.content.Context
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ${className}DialogFragment : BaseDialogFragment<${bindingName}, ${viewModelName}>() {
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
    fun newInstance() = ${className}DialogFragment()
  }
}
""".trimIndent()
}