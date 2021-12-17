package com.teamtasticoapp.databinding;
import com.teamtasticoapp.R;
import com.teamtasticoapp.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityJoinTeamConfirmationBindingImpl extends ActivityJoinTeamConfirmationBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.topBarLayout, 1);
        sViewsWithIds.put(R.id.llAboutUs, 2);
        sViewsWithIds.put(R.id.tvJoinTeamConfirmTitle, 3);
        sViewsWithIds.put(R.id.llProfile, 4);
        sViewsWithIds.put(R.id.ivProfile, 5);
        sViewsWithIds.put(R.id.tvCongratulations, 6);
        sViewsWithIds.put(R.id.tvPlayerName, 7);
        sViewsWithIds.put(R.id.tvCongratu, 8);
        sViewsWithIds.put(R.id.tvTeamName, 9);
        sViewsWithIds.put(R.id.tvSendCode, 10);
        sViewsWithIds.put(R.id.tvTeamCode, 11);
        sViewsWithIds.put(R.id.visitTeamPages, 12);
        sViewsWithIds.put(R.id.bottomMenu, 13);
        sViewsWithIds.put(R.id.llTeam, 14);
        sViewsWithIds.put(R.id.ivTeam, 15);
        sViewsWithIds.put(R.id.llChat, 16);
        sViewsWithIds.put(R.id.ivChat, 17);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityJoinTeamConfirmationBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }
    private ActivityJoinTeamConfirmationBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.LinearLayout) bindings[13]
            , (android.widget.ImageView) bindings[17]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.ImageView) bindings[15]
            , (android.widget.LinearLayout) bindings[2]
            , (android.widget.LinearLayout) bindings[16]
            , (android.widget.LinearLayout) bindings[4]
            , (android.widget.LinearLayout) bindings[14]
            , (android.widget.LinearLayout) bindings[1]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[6]
            , (com.teamtasticoapp.util.SFDSBTextView) bindings[3]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[9]
            , (android.widget.Button) bindings[12]
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