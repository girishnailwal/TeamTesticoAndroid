package com.teamtasticoapp.databinding;
import com.teamtasticoapp.R;
import com.teamtasticoapp.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityAddedPlayerBindingImpl extends ActivityAddedPlayerBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.rLayout1, 1);
        sViewsWithIds.put(R.id.ll1, 2);
        sViewsWithIds.put(R.id.llPlayer1, 3);
        sViewsWithIds.put(R.id.ivPlayer1, 4);
        sViewsWithIds.put(R.id.ll2, 5);
        sViewsWithIds.put(R.id.llPlayer2, 6);
        sViewsWithIds.put(R.id.ivPlayer2, 7);
        sViewsWithIds.put(R.id.rLayout2, 8);
        sViewsWithIds.put(R.id.ll3, 9);
        sViewsWithIds.put(R.id.llPlayer3, 10);
        sViewsWithIds.put(R.id.ivPlayer3, 11);
        sViewsWithIds.put(R.id.ll4, 12);
        sViewsWithIds.put(R.id.llPlayer4, 13);
        sViewsWithIds.put(R.id.ivPlayer4, 14);
        sViewsWithIds.put(R.id.ll5, 15);
        sViewsWithIds.put(R.id.llPlayer5, 16);
        sViewsWithIds.put(R.id.ivPlayer5, 17);
        sViewsWithIds.put(R.id.ll6, 18);
        sViewsWithIds.put(R.id.llPlayer6, 19);
        sViewsWithIds.put(R.id.ivPlayer6, 20);
        sViewsWithIds.put(R.id.rLayout3, 21);
        sViewsWithIds.put(R.id.ll7, 22);
        sViewsWithIds.put(R.id.llPlayer7, 23);
        sViewsWithIds.put(R.id.ivPlayer7, 24);
        sViewsWithIds.put(R.id.ll8, 25);
        sViewsWithIds.put(R.id.llPlayer8, 26);
        sViewsWithIds.put(R.id.ivPlayer8, 27);
        sViewsWithIds.put(R.id.ll9, 28);
        sViewsWithIds.put(R.id.llPlayer9, 29);
        sViewsWithIds.put(R.id.ivPlayer9, 30);
        sViewsWithIds.put(R.id.ll10, 31);
        sViewsWithIds.put(R.id.llPlayer10, 32);
        sViewsWithIds.put(R.id.ivPlayer10, 33);
        sViewsWithIds.put(R.id.rLayout4, 34);
        sViewsWithIds.put(R.id.ll11, 35);
        sViewsWithIds.put(R.id.llPlayer11, 36);
        sViewsWithIds.put(R.id.ivPlayer11, 37);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityAddedPlayerBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 38, sIncludes, sViewsWithIds));
    }
    private ActivityAddedPlayerBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[4]
            , (android.widget.ImageView) bindings[33]
            , (android.widget.ImageView) bindings[37]
            , (android.widget.ImageView) bindings[7]
            , (android.widget.ImageView) bindings[11]
            , (android.widget.ImageView) bindings[14]
            , (android.widget.ImageView) bindings[17]
            , (android.widget.ImageView) bindings[20]
            , (android.widget.ImageView) bindings[24]
            , (android.widget.ImageView) bindings[27]
            , (android.widget.ImageView) bindings[30]
            , (android.widget.LinearLayout) bindings[2]
            , (android.widget.LinearLayout) bindings[31]
            , (android.widget.LinearLayout) bindings[35]
            , (android.widget.LinearLayout) bindings[5]
            , (android.widget.LinearLayout) bindings[9]
            , (android.widget.LinearLayout) bindings[12]
            , (android.widget.LinearLayout) bindings[15]
            , (android.widget.LinearLayout) bindings[18]
            , (android.widget.LinearLayout) bindings[22]
            , (android.widget.LinearLayout) bindings[25]
            , (android.widget.LinearLayout) bindings[28]
            , (android.widget.LinearLayout) bindings[3]
            , (android.widget.LinearLayout) bindings[32]
            , (android.widget.LinearLayout) bindings[36]
            , (android.widget.LinearLayout) bindings[6]
            , (android.widget.LinearLayout) bindings[10]
            , (android.widget.LinearLayout) bindings[13]
            , (android.widget.LinearLayout) bindings[16]
            , (android.widget.LinearLayout) bindings[19]
            , (android.widget.LinearLayout) bindings[23]
            , (android.widget.LinearLayout) bindings[26]
            , (android.widget.LinearLayout) bindings[29]
            , (android.widget.RelativeLayout) bindings[1]
            , (android.widget.RelativeLayout) bindings[8]
            , (android.widget.RelativeLayout) bindings[21]
            , (android.widget.RelativeLayout) bindings[34]
            );
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}