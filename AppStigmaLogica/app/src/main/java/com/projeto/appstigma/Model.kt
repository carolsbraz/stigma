package com.projeto.appstigma

import android.content.Intent
import com.example.stigma.PrincipalActivity
import com.example.stigma.R

enum class Model private constructor(val titleResId: Int, val layoutResId: Int) {
    RED(R.string.passo1, R.layout.activity_passo1),
    BLUE(R.string.passo2, R.layout.activity_passo2),
    GREEN(R.string.passo3, R.layout.activity_passo3)



}

