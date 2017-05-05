// Generated code from Butter Knife. Do not modify!
package com.warmfire.firsttest.ui;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.warmfire.firsttest.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ButterKnifeActivity_ViewBinding<T extends ButterKnifeActivity> implements Unbinder {
  protected T target;

  private View view2131492984;

  @UiThread
  public ButterKnifeActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.button1 = Utils.findRequiredViewAsType(source, R.id.butter_btn1, "field 'button1'", Button.class);
    target.img_back = Utils.findRequiredViewAsType(source, R.id.title_back, "field 'img_back'", ImageView.class);
    target.txt_title = Utils.findRequiredViewAsType(source, R.id.title_title, "field 'txt_title'", TextView.class);
    view = Utils.findRequiredView(source, R.id.butter_btn2, "method 'submit' and method 'showToast2'");
    view2131492984 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.submit();
      }
    });
    view.setOnLongClickListener(new View.OnLongClickListener() {
      @Override
      public boolean onLongClick(View p0) {
        return target.showToast2();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.button1 = null;
    target.img_back = null;
    target.txt_title = null;

    view2131492984.setOnClickListener(null);
    view2131492984.setOnLongClickListener(null);
    view2131492984 = null;

    this.target = null;
  }
}
