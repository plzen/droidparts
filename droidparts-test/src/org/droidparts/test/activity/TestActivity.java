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
package org.droidparts.test.activity;

import org.droidparts.activity.Activity;
import org.droidparts.annotation.inject.InjectFragment;
import org.droidparts.annotation.inject.InjectResource;
import org.droidparts.annotation.inject.InjectView;
import org.droidparts.annotation.serialize.SaveInstanceState;
import org.droidparts.test.R;

import android.os.Bundle;
import android.widget.TextView;

public class TestActivity extends Activity {

	@InjectResource(R.string.test_string)
	public String testString;

	@InjectView(id = R.id.view_text)
	public TextView textView;

	@InjectFragment(id = R.id.fragment)
	public TestFragment testFragment;

	@SaveInstanceState
	public String data;

	@Override
	public void onPreInject() {
		setContentView(R.layout.activity_test);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}

}
