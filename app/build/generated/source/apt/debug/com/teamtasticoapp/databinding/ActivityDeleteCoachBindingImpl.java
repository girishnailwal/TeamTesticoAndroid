package com.teamtasticoapp.databinding;
import com.teamtasticoapp.R;
import com.teamtasticoapp.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityDeleteCoachBindingImpl extends ActivityDeleteCoachBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.topBarLayout, 1);
        sViewsWithIds.put(R.id.llAboutUs, 2);
        sViewsWithIds.put(R.id.tvDeleteTeam, 3);
        sViewsWithIds.put(R.id.llProfile, 4);
        sViewsWithIds.put(R.id.ivProfile, 5);
        sViewsWithIds.put(R.id.rv_contactlist, 6);
        sViewsWithIds.put(R.id.bottomMenu, 7);
        sViewsWithIds.put(R.id.llTeam, 8);
        sViewsWithIds.put(R.id.ivTeam, 9);
        sViewsWithIds.put(R.id.llChat, 10);
        sViewsWithIds.put(R.id.ivChat, 11);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityDeleteCoachBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }
    private ActivityDeleteCoachBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.LinearLayout) bindings[7]
            , (android.widget.ImageView) bindings[11]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.LinearLayout) bindings[2]
            , (android.widget.LinearLayout) bindings[10]
            , (android.widget.LinearLayout) bindings[4]
            , (android.widget.LinearLayout) bindings[8]
            , (android.support.v7.widget.RecyclerView) bindings[6]
            , (android.widget.LinearLayout) bindings[1]
            , (com.teamtasticoapp.util.SFDSBTextView) bindings[3]
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