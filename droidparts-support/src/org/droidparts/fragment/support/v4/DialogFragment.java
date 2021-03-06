/**
 * Copyright 2015 Alex Yanchenko
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package org.droidparts.fragment.support.v4;

import org.droidparts.inner.delegate.SupportDelegate;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DialogFragment extends android.support.v4.app.DialogFragment {

	private boolean injected;

	@Override
	public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = onCreateView(savedInstanceState, inflater, container);
		SupportDelegate.onFragmentCreateView(this, view, getDialog(), savedInstanceState);
		injected = true;
		return view;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		SupportDelegate.onFragmentSaveInstanceState(this, injected, outState);
	}

	protected View onCreateView(Bundle savedInstanceState, LayoutInflater inflater, ViewGroup container) {
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	public final boolean isInjected() {
		return injected;
	}

	public void show(FragmentActivity activity) {
		SupportDelegate.showDialogFragment(activity, this);
	}

}
