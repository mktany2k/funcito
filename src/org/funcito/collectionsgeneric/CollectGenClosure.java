package org.funcito.collectionsgeneric;

import org.apache.commons.collections15.Closure;
import org.funcito.FunctionalBase;
import org.funcito.internal.InvokableState;

/*
 * Copyright 2013 Project Funcito Contributors
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class CollectGenClosure<T> implements Closure<T> {

    private FunctionalBase<T,Void> functionalBase;

    public CollectGenClosure(InvokableState state) {
        functionalBase = new FunctionalBase<T, Void>(state);
    }

    @Override
    public void execute(T from) {
        functionalBase.applyImpl(from);
    }
}