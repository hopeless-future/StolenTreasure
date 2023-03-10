package net.peakgames.ginrummyplu

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Rect
import net.peakgames.ginrummyplu.BouncerScreenSizeConstants.SCREEN_HEIGHT
import net.peakgames.ginrummyplu.BouncerScreenSizeConstants.SCREEN_WIDTH

class Bouncer(val bouncerImage: Bitmap) {

    var bouncerPositionX = SCREEN_WIDTH / 2 - bouncerImage.width / 2
    val bouncerPositionY = SCREEN_HEIGHT / 1.8f
    private val bouncerMovingSpeed = 7

    fun bouncerRectangle() = Rect(bouncerPositionX, bouncerPositionY.toInt(), bouncerPositionX + bouncerImage.width, bouncerPositionY.toInt() + bouncerImage.height)

    fun updateBouncerLeftMovement() {
        bouncerPositionX -= bouncerMovingSpeed
        if (bouncerPositionX <= 0) bouncerPositionX = 0
    }

    fun updateBouncerRightMovement() {
        bouncerPositionX += bouncerMovingSpeed
        if (bouncerPositionX + bouncerImage.width >= SCREEN_WIDTH) bouncerPositionX = SCREEN_WIDTH - bouncerImage.width
    }

    fun drawBouncer(canvas: Canvas) {
        canvas.drawBitmap(bouncerImage, bouncerPositionX.toFloat(), bouncerPositionY.toFloat(), null)
    }
}