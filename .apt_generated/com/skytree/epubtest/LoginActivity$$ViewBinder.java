// Generated code from Butter Knife. Do not modify!
package com.skytree.epubtest;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class LoginActivity$$ViewBinder<T extends com.skytree.epubtest.LoginActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296258, "field 'etPass'");
    target.etPass = finder.castView(view, 2131296258, "field 'etPass'");
    view = finder.findRequiredView(source, 2131296260, "field 'ivCosmicLogo'");
    target.ivCosmicLogo = finder.castView(view, 2131296260, "field 'ivCosmicLogo'");
    view = finder.findRequiredView(source, 2131296256, "field 'ivBeumLogo'");
    target.ivBeumLogo = finder.castView(view, 2131296256, "field 'ivBeumLogo'");
    view = finder.findRequiredView(source, 2131296257, "field 'etId'");
    target.etId = finder.castView(view, 2131296257, "field 'etId'");
    view = finder.findRequiredView(source, 2131296259, "method 'signIn'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.signIn();
        }
      });
  }

  @Override public void unbind(T target) {
    target.etPass = null;
    target.ivCosmicLogo = null;
    target.ivBeumLogo = null;
    target.etId = null;
  }
}
