[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Bitrise Status](https://app.bitrise.io/app/592faae9bcad9d95/status.svg?token=FX5OIlR9CjuhIMwWyyowmg)]

# patterns-app

This Apps purpose was to tryout some of Androids more current features.

## MotionLayout
In main_fragment.xml the new MotionLayout is used to show an animation. If the user wants to search for a pattern and clicks on the search icon at the top,
a Input field appears over the list and the list shrinks a bit in height to create space.
This orchestrated animation is simply implemented and can either be inspected via the MotionLayoutScene Editor or via the main_fragment_scene.xml. 

## Room
While the basic use of Room was already known this project ships with a prefilled database design_patterns.db. Which is loaded on first use.
For details see PatternsApplicationComponent.kt.

But since there was a change in the database model after creation of design_patterns.db a migration to version 2 of the database model was needed.
Which is also accomplished in PatternsApplicationComponent.kt

The Schemata of the database model can be found in the schemas folder. They are generated via the annotation processor configuration in build.grade and are used to verify design_patterns.db.    

## Coroutines
While it seems there are some different approaches in the correct usage of coroutines and the topic is still evolving. This project uses them at least successfully, while maybe not perfectly.

## Gestures
This is not new to Apps but I wanted to add the possibility to drag and scale pictures. This was quite easily possible with th code in DragFrameLayout.kt. 

## MVVM + Repository Pattern
Overall I oriented the project structure after some other "best practice" android projects I inspected in the lasts months. The Repository Pattern misses a remote part and it is already noticeable that use-cases would improve the single responsibility. 

## Darkmode
Darkmode is easy but since I used png Files for the pattern diagrams I had to invert them. SVG or vector drawables seemed quite a hustle for this project.

## Also
Overall the information in this App is inspired by the book Design Patterns from Gamma, Helm, Johnson and Vlissides. With some artistic freedom and own experience.

## Future
I want to improve this application with a backend to add new patterns overtime. But it is not scheduled yet.  
