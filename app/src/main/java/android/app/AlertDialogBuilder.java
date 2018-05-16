package android.app;

import java.util.*;
import java.io.*;

import android.content.*;
import android.graphics.drawable.*;
import android.view.*;
import android.widget.*;

/**
 * Alternative AlertDialogBuilder
 *
 * @author nirenr
 * @implNote written with AIDE
 */
public class AlertDialogBuilder extends AlertDialog {

  /** Application Context */
  private Context mContext;

  /** Maybe lsit */
  private ListView mListView;

  /** Maybe message */
  private String mMessage;

  /** Maybe title */
  private String mTitle;

  /** Maybe view */
  private View mView;

  public AlertDialogBuilder(Context context) {
    super(context);
    mContext = context;
    mListView = new ListView(mContext);

  }

  public AlertDialogBuilder(Context context, int theme) {
    super(context, theme);
    mContext = context;
    mListView = new ListView(mContext);
  }

  public void setPositiveButton(CharSequence text, DialogInterface.OnClickListener listener) {
    setButton(DialogInterface.BUTTON_POSITIVE, text, listener);
  }

  public void setNegativeButton(CharSequence text, DialogInterface.OnClickListener listener) {
    setButton(DialogInterface.BUTTON_NEGATIVE, text, listener);
  }

  public void setNeutralButton(CharSequence text, DialogInterface.OnClickListener listener) {
    setButton(DialogInterface.BUTTON_NEUTRAL, text, listener);
  }

  public String getTitle() {
    return mTitle;
  }

  @Override
  public void setTitle(CharSequence title) {
    mTitle = title.toString();
    super.setTitle(title);
  }

  public String getMessage() {
    return mMessage;
  }

  @Override
  public void setMessage(CharSequence message) {
    mMessage = message.toString();
    super.setMessage(message);
  }

  @Override
  public void setIcon(Drawable icon) {
    super.setIcon(icon);
  }

  public View getView() {
    return mView;
  }

  @Override
  public void setView(View view) {
    mView = view;
    super.setView(view);
  }

  public void setItems(String[] items) {
    ArrayList<String> alist = new ArrayList<String>(Arrays.asList(items));
    ArrayListAdapter adp = new ArrayListAdapter<String>(mContext, android.R.layout.simple_list_item_1, alist);
    setAdapter(adp);
  }

  public void setAdapter(ListAdapter adp) {
    if (!mListView.equals(mView))
      setView(mListView);
    mListView.setAdapter(adp);
  }


  public ListView getListView() {
    return mListView;
  }

  @Override
  public void setOnCancelListener(DialogInterface.OnCancelListener listener) {
    super.setOnCancelListener(listener);
  }

  @Override
  public void setOnDismissListener(DialogInterface.OnDismissListener listener) {
    super.setOnDismissListener(listener);
  }

  @Override
  public void show() {
    super.show();
  }

  @Override
  public void hide() {
    super.hide();
  }


  public void close() {
    super.dismiss();
  }

  @Override
  public boolean isShowing() {
    return super.isShowing();
  }


  @Override
  public void dismiss() {
    // TODO: Implement this method
    super.hide();
  }

}
