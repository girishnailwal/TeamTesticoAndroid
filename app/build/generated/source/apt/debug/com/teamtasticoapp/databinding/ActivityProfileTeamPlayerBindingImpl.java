package com.teamtasticoapp.databinding;
import com.teamtasticoapp.R;
import com.teamtasticoapp.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityProfileTeamPlayerBindingImpl extends ActivityProfileTeamPlayerBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.topBarLayout, 1);
        sViewsWithIds.put(R.id.llAboutUs, 2);
        sViewsWithIds.put(R.id.tvCreateTeam, 3);
        sViewsWithIds.put(R.id.llProfile, 4);
        sViewsWithIds.put(R.id.ivProfile, 5);
        sViewsWithIds.put(R.id.rLayoutTeamPlayer, 6);
        sViewsWithIds.put(R.id.ivPlayer, 7);
        sViewsWithIds.put(R.id.ivEdtPlayer, 8);
        sViewsWithIds.put(R.id.tvessage, 9);
        sViewsWithIds.put(R.id.tvTeamName, 10);
        sViewsWithIds.put(R.id.llName, 11);
        sViewsWithIds.put(R.id.tvUserName, 12);
        sViewsWithIds.put(R.id.tvForward, 13);
        sViewsWithIds.put(R.id.tvGmail, 14);
        sViewsWithIds.put(R.id.tvTeamCode, 15);
        sViewsWithIds.put(R.id.llLeaveTeam, 16);
        sViewsWithIds.put(R.id.ivLeaveTeam, 17);
        sViewsWithIds.put(R.id.tvLeaveTeam, 18);
        sViewsWithIds.put(R.id.llDeletePlayer, 19);
        sViewsWithIds.put(R.id.ivDeletePlayer, 20);
        sViewsWithIds.put(R.id.tvDeletePlayer, 21);
        sViewsWithIds.put(R.id.llLogOutTeam, 22);
        sViewsWithIds.put(R.id.bottomMenu, 23);
        sViewsWithIds.put(R.id.llTeam, 24);
        sViewsWithIds.put(R.id.ivTeam, 25);
        sViewsWithIds.put(R.id.llChat, 26);
        sViewsWithIds.put(R.id.ivChat, 27);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityProfileTeamPlayerBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 28, sIncludes, sViewsWithIds));
    }
    private ActivityProfileTeamPlayerBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.LinearLayout) bindings[23]
            , (android.widget.ImageView) bindings[27]
            , (android.widget.ImageView) bindings[20]
            , (android.widget.ImageView) bindings[8]
            , (android.widget.ImageView) bindings[17]
            , (net.grobas.view.PolygonImageView) bindings[7]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.ImageView) bindings[25]
            , (android.widget.LinearLayout) bindings[2]
            , (android.widget.LinearLayout) bindings[26]
            , (android.widget.LinearLayout) bindings[19]
            , (android.widget.LinearLayout) bindings[16]
            , (android.widget.LinearLayout) bindings[22]
            , (android.widget.LinearLayout) bindings[11]
            , (android.widget.LinearLayout) bindings[4]
            , (android.widget.LinearLayout) bindings[24]
            , (android.widget.RelativeLayout) bindings[6]
            , (android.widget.LinearLayout) bindings[1]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[21]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[18]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[9]
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