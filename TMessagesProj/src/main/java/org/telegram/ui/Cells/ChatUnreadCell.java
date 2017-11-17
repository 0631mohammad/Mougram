/*
 * This is the source code of Telegram for Android v. 3.x.x.
 * It is licensed under GNU GPL v. 2 or later.
 * You should have received a copy of the license in this archive (see LICENSE).
 *
 * Copyright Nikolai Kudashov, 2013-2017.
 */

package org.telegram.ui.Cells;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import org.mougram.messenger.AndroidUtilities;
import org.mougram.messenger.R;
import org.telegram.ui.Components.LayoutHelper;
import org.telegram.ui.ActionBar.Theme;

public class ChatUnreadCell extends FrameLayout {

    private TextView textView;
    private ImageView imageView;
    private FrameLayout backgroundLayout;

    public ChatUnreadCell(Context context) {
        super(context);

        backgroundLayout = new FrameLayout(context);
        backgroundLayout.setBackgroundResource(R.drawable.newmsg_divider);
        backgroundLayout.getBackground().setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_chat_unreadMessagesStartBackground), PorterDuff.Mode.MULTIPLY));
        addView(backgroundLayout, LayoutHelper.createFrame(LayoutHelper.MATCH_PARENT, 27, Gravity.LEFT | Gravity.TOP, 0, 7, 0, 0));

        imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.ic_ab_new);
        imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_chat_unreadMessagesStartArrowIcon), PorterDuff.Mode.MULTIPLY));
        imageView.setPadding(0, AndroidUtilities.dp(2), 0, 0);
        backgroundLayout.addView(imageView, LayoutHelper.createFrame(LayoutHelper.WRAP_CONTENT, LayoutHelper.WRAP_CONTENT, Gravity.RIGHT | Gravity.CENTER_VERTICAL, 0, 0, 10, 0));

        textView = new TextView(context);
        textView.setPadding(0, 0, 0, AndroidUtilities.dp(1));
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
        textView.setTextColor(Theme.getColor(Theme.key_chat_unreadMessagesStartText));
        textView.setTypeface(AndroidUtilities.getTypeface("fonts/rmedium.ttf"));
        addView(textView, LayoutHelper.createFrame(LayoutHelper.WRAP_CONTENT, LayoutHelper.WRAP_CONTENT, Gravity.CENTER));
    }

    public void setText(String text) {
        textView.setText(text);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public TextView getTextView() {
        return textView;
    }

    public FrameLayout getBackgroundLayout() {
        return backgroundLayout;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(40), MeasureSpec.EXACTLY));
    }
}
