/*
 * Copyright 2012 Project Funcito Contributors
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.funcito.collectionsgeneric;

import org.apache.commons.collections15.Predicate;
import org.funcito.FuncitoCollectGen;
import org.funcito.internal.InvokableState;
import org.funcito.functorbase.NullValidatingPredicateBase;

public class CollectGenPredicate<T> implements Predicate<T> {

    private NullValidatingPredicateBase<T> functionalBase;

    public CollectGenPredicate(InvokableState state) {
        try {
            functionalBase = new NullValidatingPredicateBase<T>(state, Predicate.class,
                    FuncitoCollectGen.class.getMethod("predicateFor", Boolean.class, boolean.class));
        } catch (NoSuchMethodException e) { // ignored
        }
    }

    @Override
    public boolean evaluate(T from) {
        return functionalBase.applyImpl(from);
    }

}
