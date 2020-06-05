package de.traendy.patterns.ui.detail

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.View
import android.widget.FrameLayout
import androidx.customview.widget.ViewDragHelper
import kotlin.math.max
import kotlin.math.min


/**
 * A [FrameLayout] that allows the user to drag and reposition child views.
 * src https://github.com/android/user-interface-samples/blob/master/ElevationDrag/Application/src/main/java/com/example/android/elevationdrag/DragFrameLayout.java
 */

class DragFrameLayout
    @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    FrameLayout(context, attrs, defStyleAttr) {
    /**
     * The list of [View]s that will be draggable.
     */
    private var mDragView: View? = null

    private val mDragHelper: ViewDragHelper

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        val action = ev.actionMasked
        if (action == MotionEvent.ACTION_CANCEL || action == MotionEvent.ACTION_UP) {
            mDragHelper.cancel()
            return false
        }
        return mDragHelper.shouldInterceptTouchEvent(ev)
    }

    private var mScaleFactor = 1.0f

    private val mScaleListener = object : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScale(detector: ScaleGestureDetector): Boolean {

            mScaleFactor *= max(0.1f, min(detector.scaleFactor, 5.0f))
            mDragView?.scaleX = mScaleFactor
            mDragView?.scaleY = mScaleFactor
            return true
        }
    }
    private val mScaleGestureDetector = ScaleGestureDetector(getContext(), mScaleListener)

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(ev: MotionEvent): Boolean {
        mDragHelper.processTouchEvent(MotionEvent.obtain(ev))
        return mScaleGestureDetector.onTouchEvent(
            MotionEvent.obtain(ev)
        )
    }

    /**
     * Adds a new [View] to the list of views that are draggable within the container.
     * @param dragView the [View] to make draggable
     */
    fun addDragView(dragView: View) {
        mDragView = dragView
    }

    init {
        mDragHelper = ViewDragHelper.create(this, 1.0f, object : ViewDragHelper.Callback() {
            override fun tryCaptureView(child: View, pointerId: Int): Boolean {
                return mDragView == child
            }
            override fun clampViewPositionHorizontal(child: View, left: Int, dx: Int): Int {
                return left
            }

            override fun clampViewPositionVertical(child: View, top: Int, dy: Int): Int {
                return top
            }
        })
    }



}