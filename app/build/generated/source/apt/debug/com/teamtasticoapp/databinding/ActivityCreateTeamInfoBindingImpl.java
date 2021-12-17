package com.teamtasticoapp.databinding;
import com.teamtasticoapp.R;
import com.teamtasticoapp.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityCreateTeamInfoBindingImpl extends ActivityCreateTeamInfoBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.topBarLayout, 1);
        sViewsWithIds.put(R.id.llAboutUs, 2);
        sViewsWithIds.put(R.id.ivAboutUs, 3);
        sViewsWithIds.put(R.id.tvCreateTeamInfoTitle, 4);
        sViewsWithIds.put(R.id.llProfile, 5);
        sViewsWithIds.put(R.id.ivProfile, 6);
        sViewsWithIds.put(R.id.tvT, 7);
        sViewsWithIds.put(R.id.t, 8);
        sViewsWithIds.put(R.id.tvvv, 9);
        sViewsWithIds.put(R.id.tvvvcc, 10);
        sViewsWithIds.put(R.id.tsss, 11);
        sViewsWithIds.put(R.id.llUploadPhoto, 12);
        sViewsWithIds.put(R.id.ivUploadPhoto, 13);
        sViewsWithIds.put(R.id.edtName, 14);
        sViewsWithIds.put(R.id.edtPosition, 15);
        sViewsWithIds.put(R.id.edtEmail, 16);
        sViewsWithIds.put(R.id.password_edt, 17);
        sViewsWithIds.put(R.id.password_on_off_img, 18);
        sViewsWithIds.put(R.id.creatTeam, 19);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityCreateTeamInfoBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 20, sIncludes, sViewsWithIds));
    }
    private ActivityCreateTeamInfoBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[19]
            , (android.widget.EditText) bindings[16]
            , (android.widget.EditText) bindings[14]
            , (android.widget.EditText) bindings[15]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.ImageView) bindings[6]
            , (net.grobas.view.PolygonImageView) bindings[13]
            , (android.widget.LinearLayout) bindings[2]
            , (android.widget.LinearLayout) bindings[5]
            , (android.widget.LinearLayout) bindings[12]
            , (android.widget.EditText) bindings[17]
            , (android.widget.ImageView) bindings[18]
            , (android.widget.TextView) bindings[8]
            , (android.widget.LinearLayout) bindings[1]
            , (android.widget.TextView) bindings[11]
            , (com.teamtasticoapp.util.SFDSBTextView) bindings[4]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[10]
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