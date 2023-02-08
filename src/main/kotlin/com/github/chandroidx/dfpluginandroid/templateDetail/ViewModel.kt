package com.github.chandroidx.dfpluginandroid.templateDetail

fun createViewModel(
        packageName: String,
        className: String,
): String {
    val viewModelName = "${className}ViewModel"

    return """package ${packageName}.viewModel
import ai.deepfine.presentation.base.BaseViewModelImpl
import ai.deepfine.presentation.coroutine.BaseCoroutineScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class $viewModelName @Inject constructor(
  scope: BaseCoroutineScope,
) : BaseViewModelImpl(), BaseCoroutineScope by scope {

  override fun clearViewModel() {
    releaseCoroutine()
  }
}""".trimIndent()
}