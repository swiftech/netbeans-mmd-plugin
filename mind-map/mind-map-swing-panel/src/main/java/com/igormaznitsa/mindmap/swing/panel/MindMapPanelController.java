/*
 * Copyright 2015 Igor Maznitsa.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.igormaznitsa.mindmap.swing.panel;

import com.igormaznitsa.mindmap.swing.panel.ui.AbstractElement;
import com.igormaznitsa.mindmap.swing.panel.ui.ElementPart;
import java.awt.Point;
import javax.swing.JPopupMenu;

public interface MindMapPanelController {
  boolean isUnfoldCollapsedTopicDropTarget(MindMapPanel source);
  boolean isCopyColorInfoFromParentToNewChildAllowed(MindMapPanel source);
  boolean isSelectionAllowed(MindMapPanel source);
  boolean isElementDragAllowed(MindMapPanel source);
  boolean isMouseMoveProcessingAllowed(MindMapPanel source);
  boolean isMouseWheelProcessingAllowed(MindMapPanel source);
  boolean isMouseClickProcessingAllowed(MindMapPanel source);
  MindMapPanelConfig provideConfigForMindMapPanel(MindMapPanel source);
  JPopupMenu makePopUpForMindMapPanel(MindMapPanel source,  Point point, AbstractElement elementUnderMouse,  ElementPart elementPartUnderMouse);
  DialogProvider getDialogProvider(MindMapPanel source);
}
