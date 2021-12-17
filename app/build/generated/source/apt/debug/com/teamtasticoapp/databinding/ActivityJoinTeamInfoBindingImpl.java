package com.teamtasticoapp.databinding;
import com.teamtasticoapp.R;
import com.teamtasticoapp.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityJoinTeamInfoBindingImpl extends ActivityJoinTeamInfoBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.topBarLayout, 1);
        sViewsWithIds.put(R.id.llAboutUs, 2);
        sViewsWithIds.put(R.id.tvJoinTeamInfoTitle, 3);
        sViewsWithIds.put(R.id.llProfile, 4);
        sViewsWithIds.put(R.id.ivProfile, 5);
        sViewsWithIds.put(R.id.tvT, 6);
        sViewsWithIds.put(R.id.tvTeamName, 7);
        sViewsWithIds.put(R.id.t, 8);
        sViewsWithIds.put(R.id.tvvv, 9);
        sViewsWithIds.put(R.id.llUploadPhoto, 10);
        sViewsWithIds.put(R.id.ivUploadPhoto, 11);
        sViewsWithIds.put(R.id.edtName, 12);
        sViewsWithIds.put(R.id.edtPosition, 13);
        sViewsWithIds.put(R.id.edtEmail, 14);
        sViewsWithIds.put(R.id.password_edt, 15);
        sViewsWithIds.put(R.id.password_on_off_img, 16);
        sViewsWithIds.put(R.id.joinTeam, 17);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityJoinTeamInfoBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }
    private ActivityJoinTeamInfoBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.EditText) bindings[14]
            , (android.widget.EditText) bindings[12]
            , (android.widget.EditText) bindings[13]
            , (android.widget.ImageView) bindings[5]
            , (net.grobas.view.PolygonImageView) bindings[11]
            , (android.widget.Button) bindings[17]
            , (android.widget.LinearLayout) bindings[2]
            , (android.widget.LinearLayout) bindings[4]
            , (android.widget.LinearLayout) bindings[10]
            , (android.widget.EditText) bindings[15]
            , (android.widget.ImageView) bindings[16]
            , (android.widget.TextView) bindings[8]
            , (android.widget.LinearLayout) bindings[1]
            , (com.teamtasticoapp.util.SFDSBTextView) bindings[3]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[9]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
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