package com.example.decorator.ui.behavior.decoratorBehavior

abstract class CodeDecorator (val code: Code): Code() {
    override fun GetCode(): Int {
        return code.GetCode()
    }
}