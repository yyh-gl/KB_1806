// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package com.mybossseasonfinal.justthejob.DI.Module;

import com.mybossseasonfinal.justthejob.MainActivity.MainFragment.EntrySheetFragment.EntrySheetContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class FragmentModule_ProvideEntrySheetFragmentViewFactory
    implements Factory<EntrySheetContract.View> {
  private final FragmentModule module;

  public FragmentModule_ProvideEntrySheetFragmentViewFactory(FragmentModule module) {
    this.module = module;
  }

  @Override
  public EntrySheetContract.View get() {
    return Preconditions.checkNotNull(
        module.provideEntrySheetFragmentView(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<EntrySheetContract.View> create(FragmentModule module) {
    return new FragmentModule_ProvideEntrySheetFragmentViewFactory(module);
  }
}