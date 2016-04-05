// Copyright 2016 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.ads.adwords.lib.selectorfields.v201603.cm;

import com.google.api.ads.adwords.lib.selectorfields.EntityField;
import com.google.api.ads.adwords.lib.selectorfields.Filterable;

/**
 * A {@code Enum} to facilitate the selection of fields for {@code CustomerFeed}.
 */
public enum CustomerFeedField implements EntityField {

  // Fields constants definitions

  /**
   * Id of the Feed associated with the CustomerFeed.
   */
  @Filterable
  FeedId(true),

  /**
   * Matching function associated with the CustomerFeed.
   * The matching function is used to filter the set of feed items selected.
   */
  MatchingFunction(false),

  /**
   * Indicates which <a href="/adwords/api/docs/appendix/placeholders">placeholder types</a> the feed may populate under the connected customer.
   */
  @Filterable
  PlaceholderTypes(true),

  /**
   * Status of the CustomerFeed.
   */
  @Filterable
  Status(true),

  ;

  private final boolean isFilterable;

  private CustomerFeedField(boolean isFilterable) {
    this.isFilterable = isFilterable;
  }

  @Override
  public boolean isFilterable() {
    return this.isFilterable;
  }

}
