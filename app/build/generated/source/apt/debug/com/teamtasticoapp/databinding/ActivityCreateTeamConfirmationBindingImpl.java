package com.teamtasticoapp.databinding;
import com.teamtasticoapp.R;
import com.teamtasticoapp.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityCreateTeamConfirmationBindingImpl extends ActivityCreateTeamConfirmationBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.topBarLayout, 1);
        sViewsWithIds.put(R.id.llAboutUs, 2);
        sViewsWithIds.put(R.id.tvCreateTeamConfirmTitle, 3);
        sViewsWithIds.put(R.id.llProfile, 4);
        sViewsWithIds.put(R.id.ivProfile, 5);
        sViewsWithIds.put(R.id.tvCongratulations, 6);
        sViewsWithIds.put(R.id.tvName, 7);
        sViewsWithIds.put(R.id.tvCongratu, 8);
        sViewsWithIds.put(R.id.tvTeamName, 9);
        sViewsWithIds.put(R.id.tvContu, 10);
        sViewsWithIds.put(R.id.tvSendCode, 11);
        sViewsWithIds.put(R.id.tvTeamCode, 12);
        sViewsWithIds.put(R.id.visitTeamPage, 13);
        sViewsWithIds.put(R.id.bottomMenu, 14);
        sViewsWithIds.put(R.id.llTeam, 15);
        sViewsWithIds.put(R.id.ivTeam, 16);
        sViewsWithIds.put(R.id.llChat, 17);
        sViewsWithIds.put(R.id.ivChat, 18);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityCreateTeamConfirmationBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 19, sIncludes, sViewsWithIds));
    }
    private ActivityCreateTeamConfirmationBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.LinearLayout) bindings[14]
            , (android.widget.ImageView) bindings[18]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.ImageView) bindings[16]
            , (android.widget.LinearLayout) bindings[2]
            , (android.widget.LinearLayout) bindings[17]
            , (android.widget.LinearLayout) bindings[4]
            , (android.widget.LinearLayout) bindings[15]
            , (android.widget.LinearLayout) bindings[1]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[10]
            , (com.teamtasticoapp.util.SFDSBTextView) bindings[3]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[9]
            , (android.widget.Button) bindings[13]
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