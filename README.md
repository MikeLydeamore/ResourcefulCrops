#Resources, resources, resources!

A replacement to MagicalCrops since the dev seems to have poofed.

This rewrite will automagically grab Ore Dictionary entries and create crops/seeds for them. Also includes a blacklist for any you don't want added.

##Dev setup

###Workspace Setup
1. Fork/Clone and run `gradlew setupDecompWorkspace` then (if you use Eclipse) `gradlew eclipse` or (if you use IDEA) `gradlew idea`. This process should automatically setup the libs listed below.
2. Open in IDE of your choice.
3. You should be all setup now.

###Dependencies
All of these (must be deobfuscated) are required for the dev workspace to work correctly:

* ttCore (Automagically added to workspace with Maven)
* BloodMagic (Not needed yet, but once compat is setup, you will need it)
* Thaumcraft (Not needed yet, but once compat is setup, you will need it)

##Suggestions or Feedback?

[Join my channel](https://webchat.esper.net/?channels=tehnut) (#TehNut) on [Espernet](https://www.esper.net/) and discuss there.

##PWBAQ (Probably Will be Asked Questions):

* __Are you allowed to do this?__
   
   Yup.

* __Will you bring back X from MagicalCrops?__
   
   Nope.

* __OMGWTF I CAN'T FIND SEEDS FOR THE ORE YOU ADD?!?!?!__
   
   Nope.

* __Can you port to Minecraft 1.X.X?__ 
   
   Nope. 1.7.10+ only.

##What Needs to be Done
(Listed from most important to least)

1. Blaze seed must say "420" in the tooltip.

2. Seeds plant crop of their own NBT value. No more of these "Null" Crops.

3. Crops drop seed of their own NBT value. No more dropping wheat seeds.

4. Add the actual resources you get from the crops.

5. Add recipes for the resources to get the stuff you actually want.

6. Better way of adding non-oredict crops/seeds.

7. Cool rendering of crops.

8. Json configs for seed/crop coloring. No more hardcoded colors.

9. Probably some other stuff I can't think of right now.

##What Does it do Already?

1. Grabs OreDictionary entries and creates the seeds/crops with their own NBT value.

2. Plants a null crop. Yay!

3. Working blacklist for Ingots, Dusts, and Gems. Working whitelist for non-oredicty things.

4. Config creation, ConfigGui creation, Config usage.

5. Worldgen in the Nether and Overworld for the ore.