package com.example.weatherinfo;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

    public class Durationscroller extends Scroller {

        private double scrollFactor = 1;

        public Durationscroller(Context context) {
            super(context);
        }

        public Durationscroller(Context context, Interpolator interpolator) {
            super(context, (android.view.animation.Interpolator) interpolator);
        }

        public void setScrollDurationFactor(double scrollFactor) {
            this.scrollFactor = scrollFactor;
        }

        @Override
        public void startScroll(int startX, int startY, int dx, int dy, int duration) {
            super.startScroll(startX, startY, dx, dy, (int)(duration * scrollFactor));
        }
    }

