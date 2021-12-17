package com.teamtasticoapp.databinding;
import com.teamtasticoapp.R;
import com.teamtasticoapp.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityProfileCoachBindingImpl extends ActivityProfileCoachBinding  {

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
        sViewsWithIds.put(R.id.scrollView, 6);
        sViewsWithIds.put(R.id.rLayoutCoach, 7);
        sViewsWithIds.put(R.id.ivCoach, 8);
        sViewsWithIds.put(R.id.ivEdtCoach, 9);
        sViewsWithIds.put(R.id.tvessage, 10);
        sViewsWithIds.put(R.id.tvTeamName, 11);
        sViewsWithIds.put(R.id.llName, 12);
        sViewsWithIds.put(R.id.tvUserName, 13);
        sViewsWithIds.put(R.id.tvMessage, 14);
        sViewsWithIds.put(R.id.tvForward, 15);
        sViewsWithIds.put(R.id.tvGmail, 16);
        sViewsWithIds.put(R.id.tvTeamCode, 17);
        sViewsWithIds.put(R.id.llDeleteTeam, 18);
        sViewsWithIds.put(R.id.ivDeleteTeam, 19);
        sViewsWithIds.put(R.id.tvDeleteTeam, 20);
        sViewsWithIds.put(R.id.llLogOutTeam, 21);
        sViewsWithIds.put(R.id.bottomMenu, 22);
        sViewsWithIds.put(R.id.llTeam, 23);
        sViewsWithIds.put(R.id.ivTeam, 24);
        sViewsWithIds.put(R.id.llChat, 25);
        sViewsWithIds.put(R.id.ivChat, 26);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityProfileCoachBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 27, sIncludes, sViewsWithIds));
    }
    private ActivityProfileCoachBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.LinearLayout) bindings[22]
            , (android.widget.ImageView) bindings[26]
            , (net.grobas.view.PolygonImageView) bindings[8]
            , (android.widget.ImageView) bindings[19]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.ImageView) bindings[24]
            , (android.widget.LinearLayout) bindings[2]
            , (android.widget.LinearLayout) bindings[25]
            , (android.widget.LinearLayout) bindings[18]
            , (android.widget.LinearLayout) bindings[21]
            , (android.widget.LinearLayout) bindings[12]
            , (android.widget.LinearLayout) bindings[4]
            , (android.widget.LinearLayout) bindings[23]
            , (android.widget.RelativeLayout) bindings[7]
            , (android.widget.ScrollView) bindings[6]
            , (android.widget.LinearLayout) bindings[1]
            , (com.teamtasticoapp.util.SFDSBTextView) bindings[3]
            , (android.widget.TextView) bindings[20]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[10]
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