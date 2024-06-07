///////////////////////////////////////////////////////////////////////////////////////////////////
// Program to create a guided character creator and character display for the TTRPG, Pathfinder 2e//
// Written by Ryan Janis                                                                         //
// Program Originally Created in January 2024                                                    //
// Modified: February, March, April, May 2024                                                    //
// Language: Java (IntelliJ), utilizing Java Swing                                               //
///////////////////////////////////////////////////////////////////////////////////////////////////
package com.example.pathfindercharactercreator;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class PathfinderCharacterCreator extends JFrame {

    private JTextField strField;
    private JTextField dexField;
    private JTextField conField;
    private JTextField intField;
    private JTextField wisField;
    private JTextField chaField;
    private JTextField characterNameField;
    private JTextField healthField;
    private JComboBox<String> ancestryComboBox;
    private JComboBox<String> ancestryFeats1ComboBox;
    private JComboBox<String> ancestryFeats5ComboBox;
    private JComboBox<String> ancestryFeats9ComboBox;
    private JComboBox<String> ancestryFeats13ComboBox;
    private JComboBox<String> heritageComboBox;
    private JComboBox<String> backgroundComboBox;
    private JComboBox<Integer> levelComboBox;
    private static JComboBox<String> classComboBox;
    private JComboBox<String> featClass1ComboBox;
    private JComboBox<String> featClass2ComboBox;
    private JComboBox<String> featClass4ComboBox;
    private JComboBox<String> featClass6ComboBox;
    private JComboBox<String> featClass8ComboBox;
    private JComboBox<String> featClass10ComboBox;
    private JComboBox<String> featClass12ComboBox;
    private JComboBox<String> featClass14ComboBox;
    private JComboBox<String> featClass16ComboBox;
    private JComboBox<String> featClass18ComboBox;
    private JComboBox<String> featClass20ComboBox;

    private JComboBox<String> featGeneral3ComboBox;
    private JComboBox<String> featGeneral7ComboBox;
    private JComboBox<String> featGeneral11ComboBox;
    private JComboBox<String> featGeneral15ComboBox;
    private JComboBox<String> featGeneral19ComboBox;
    private JComboBox<String> featSkill2ComboBox;
    private JComboBox<String> featSkill4ComboBox;
    private JComboBox<String> featSkill6ComboBox;
    private JComboBox<String> featSkill8ComboBox;
    private JComboBox<String> featSkill10ComboBox;
    private JComboBox<String> featSkill12ComboBox;
    private JComboBox<String> featSkill14ComboBox;
    private JComboBox<String> featSkill16ComboBox;
    private JComboBox<String> featSkill18ComboBox;
    private JComboBox<String> featSkill20ComboBox;
    private JLabel classFeaturesLabel1;
    private JLabel classFeaturesLabel3;
    private JLabel classFeaturesLabel5;
    private JLabel classFeaturesLabel7;
    private JLabel classFeaturesLabel9;
    private JLabel classFeaturesLabel11;
    private JLabel classFeaturesLabel13;
    private JLabel classFeaturesLabel15;
    private JLabel classFeaturesLabel17;
    private JLabel classFeaturesLabel19;
    final int[] acrobatics = {0};
    final int[] arcana = {0};
    final int[] athletics = {0};
    final int[] crafting = {0};
    final int[] deception = {0};
    final int[] diplomacy = {0};
    final int[] intimidation = {0};
    final int[] medicine = {0};
    final int[] nature = {0};
    final int[] occultism = {0};
    final int[] performance = {0};
    final int[] religion = {0};
    final int[] society = {0};
    final int[] stealth = {0};
    final int[] survival = {0};
    final int[] thievery = {0};
    private final Map<String, String> classInfoMap = new HashMap<>();
    private final Map<String, String> featInfoMap = new HashMap<>();

    // Initializing all the strings for the names of various feats, and other options that will be used to find information later
    private final String[] ancestries = {"--None Selected--", "Human", "Elf", "Dwarf", "Gnome", "Halfling"};
    private final String[][] heritages = {
            {"-"},
            {"--None Selected--", "Versatile Heritage", "Skilled Heritage"},
            {"--None Selected--", "Arctic Elf", "Cavern Elf", "Woodland Elf"},
            {"--None Selected--", "Strong-Blooded Dwarf", "Rock Dwarf", "Forge Dwarf"},
            {"--None Selected--", "Chameleon Gnome", "Umbral Gnome", "Sensate Gnome"},
            {"--None Selected--", "Gutsy Halfling", "Hillock Halfling", "Wildwood Halfling"}
    };
    private final String[][] ancestryFeats1 = {
            {"-"},
            {"--None Selected--", "Adapted Cantrip", "Cooperative Nature", "General Training", "Haughty Obstinacy", "Natural Ambition", "Natural Skill", "Unconventional Weaponry"}, //Human
            {"--None Selected--", "Ancestral Longevity", "Elven Lore", "Elven Weapon Familiarity", "Forlorn", "Nimble Elf", "Otherworldy Magic", "Unwaverinmg Mien"}, //Elf
            {"--None Selected--", "Dwarven Lore", "Dwarven Weapon Familiarity", "Rock Runner", "Stonecunning", "Unburdened Iron", "Vengeful Hatred"}, //Dwarf
            {"--None Selected--", "Animal Accomplice", "Animal Elocutionist", "Burrow Elocutionist", "Fey Fellowship", "First World Magic", "Gnome Obsession", "Gnome Weapon Familiarity", "Illusion Sense"}, //Gnome
            {"--None Selected--", "Distracting Shadows", "Halfling Lore", "Halfling Weapon Familiarity", "Sure Feet", "Titan Slinger", "Unfettered Halfling", "Watchful Halfling"} //Halfling
    };
    private final String[][] ancestryFeats5 = {
            {"-"},
            {"--None Selected--", "Adaptive Adept", "Clever Improviser"}, //Human
            {"--None Selected--", "Ageless Patience", "Elven Weapon Elegance"}, //Elf
            {"--None Selected--", "Boulder Roll", "Dwarven Weapon Cunning"}, //Dwarf
            {"--None Selected--", "Energized Font", "Gnome Weapon Innovator"}, //Gnome
            {"--None Selected--", "Cultural Adaptability", "Halfling Weapon Trickster"} //Halfling
    };
    private final String[][] ancestryFeats9 = {
            {"-"},
            {"--None Selected--", "Cooperative Soul", "Multitalented"}, //Human
            {"--None Selected--", "Elf Step", "Expert Longevity"}, //Elf
            {"--None Selected--", "Mountain's Stoutness", "Stonewalker"}, //Dwarf
            {"--None Selected--", "First World Adept", "Vivacious Conduit"}, //Gnome
            {"--None Selected--", "Guiding Luck", "Irrepressible"} //Halfling
    };
    private final String[][] ancestryFeats13 = {
            {"-"},
            {"--None Selected--", "Unconventional Expertise"}, //Human
            {"--None Selected--", "Universal Longevity", "Elven Weapon Expertise"}, //Elf
            {"--None Selected--", "Dwarven Weapon Expertise"}, //Dwarf
            {"--None Selected--", "Gnome Weapon Expertise"}, //Gnome
            {"--None Selected--", "Ceaseless Shadows", "Halfling Weapon Expertise"} //Halfling
    };


    private final String[] classes = {"--None Selected--", "Barbarian", "Bard","Champion", "Cleric", "Druid", "Fighter","Monk", "Ranger", "Rogue", "Sorcerer", "Wizard"};
    private final String[][] classFeats1 = {
            {"-"},
            {"--None Selected--", "Acute Vision", "Moment Of Clarity", "Raging Intimidation", "Raging Thrower", "Sudden Charge"}, //Barbarian
            {"--None Selected--", "Bardic Lore", "Lingering Composition", "Reach Spell", "Versatile Performance"}, //Bard
            {"--None Selected--", "Deity's Domain", "Ranged Reprisal", "Unimpeded Step", "Weight of Guilt"}, //Champion
            {"--None Selected--", "Deadly Simplicity", "Domain Initiate", "Harming Hands", "Healing Hands", "Holy Castigation", "Reach Spell"}, //Cleric
            {"--None Selected--", "Animal Companion", "Leshy Familiar", "Reach Spell", "Storm Born", "Widen Spell", "Wild Shape"}, //Druid
            {"--None Selected--", "Double Slice", "Exacting Strike", "Point-Blank Shot", "Power Attack", "Reactive Shield", "Snagging Strike", "Sudden Charge"}, //Fighter
            {"--None Selected--", "Crane Stance", "Dragon Stance", "Ki Rush", "Ki Strike", "Monastic Weaponry", "Mountain Stance", "Tiger Stance", "Wolf Stance"}, //Monk
            {"--None Selected--", "Animal Companion", "Crossbow Ace", "Hunted Shot", "Monster Hunter", "Twin Takedown"}, //Ranger
            {"--None Selected--", "Nimble Dodge", "Trap Finder", "Twin Feint", "You're Next"}, //Rogue
            {"--None Selected--", "Counterspell", "Dangerous Sorcery", "Familiar", "Reach Spell", "Widen Spell"}, //Sorcerer
            {"--None Selected--", "Counterspell", "Eschew Materials", "Familiar", "Hand Of The Apprentice", "Reach Spell", "Widen Spell"} //Wizard
    };

    private final String[][] classFeats2 = {
            {"-"},
            {"--None Selected--", "Acute Scent", "Furious Finish", "No Escape", "Second Wind", "Shake It Off"}, //Barbarian
            {"--None Selected--", "Cantrip Expansion", "Esoteric Polymath", "Inspire Competence", "Loremaster's Etude", "Multifarious Muse"}, //Bard
            {"--None Selected--", "Divine Grace", "Dragonslayer Oath", "Fiendsbane Oath", "Shining Oath", "Vengeful Oath"}, //Champion
            {"--None Selected--", "Cantrip Expansion", "Communal Healing", "Emblazon Armament", "Sap Life", "Turn Undead", "Versatile Font"}, //Cleric
            {"--None Selected--", "Call Of The Wild", "Enhanced Familiar", "Order Explorer", "Poison Resistance"}, //Druid
            {"--None Selected--", "Aggressive Block", "Assisting Shot", "Brutish Shove", "Combat Grab", "Dueling Parry", "Intimidating Strike", "Lunge"}, //Fighter
            {"--None Selected--", "Brawling Focus", "Crushing Grab", "Dancing Leaf", "Elemental Fist", "Stunning Fist"}, //Monk
            {"--None Selected--", "Favored Terrain", "Hunter's Aim", "Monster Warden", "Quick Draw", "Wild Empathy"}, //Ranger
            {"--None Selected--", "Brutal Beating", "Distracting Feint", "Minor Magic", "Mobility", "Quick Draw", "Unbalancing Blow"}, //Rogue
            {"--None Selected--", "Cantrip Expansion", "Enhanced Familiar"}, //Sorcerer
            {"--None Selected--", "Cantrip Expansion", "Conceal Spell", "Enhanced Familiar"} //Wizard
    };

    private final String[][] classFeats4 = {
            {"-"},
            {"--None Selected--", "Fast Movement", "Raging Athlete", "Swipe", "Wounded Rage"}, //Barbarian
            {"--None Selected--", "Inspire Defense", "Melodious Spell", "Triple Time", "Versatile Signature"}, //Bard
            {"--None Selected--", "Aura of Courage", "Divine Health", "Mercy"}, //Champion
            {"--None Selected--", "Channel Smite", "Command Undead", "Directed Channel", "Improved Communal Healing", "Necrotic Infusion"}, //Cleric
            {"--None Selected--", "Form Control", "Mature Animal Companion (Druid)", "Order Magic", "Thousand Faces", "Woodland Stride"}, //Druid
            {"--None Selected--", "Double Shot", "Dual-Handed Assault", "Knockdown", "Powerful Shove", "Quick Reversal", "Shielded Stride", "Swipe", "Twin Parry"}, //Fighter
            {"--None Selected--", "Deflect Arrow", "Flurry Of Maneuvers", "Flying Kick", "Guarded Movement", "Stand Still", "Wholeness Of Body"}, //Monk
            {"--None Selected--", "Companion's Cry", "Disrupt Prey", "Far Shot", "Favored Enemy", "Running Reload", "Scout's Warning", "Snare Specialist", "Twin Parry"}, //Ranger
            {"--None Selected--", "Battle Assessment", "Dread Striker", "Magical Trickster", "Poison Weapon", "Reactive Pursuit", "Sabotage", "Scout's Warning"}, //Rogue
            {"--None Selected--", "Arcane Evolution", "Bespell Weapon", "Divine Evolution", "Occult Evolution", "Primal Evolution"}, //Sorcerer
            {"--None Selected--", "Bespell Weapon", "Linked Focus", "Silent Spell"} //Wizard
    };

    private final String[][] classFeats6 = {
            {"-"},
            {"--None Selected--", "Animal Skin", "Attack Of Opportunity", "Brutal Bully", "Cleave", "Dragon's Breath Rage", "Giant's Stature", "Spirit's Interference"}, //Barbarian
            {"--None Selected--", "Dirge Of Doom", "Harmonize", "Steady Spellcasting"}, //Bard
            {"--None Selected--", "Attack Of Opportunity", "Litany Against Wrath", "Loyal Warhorse", "Shield Warden", "Smite Evil"}, //Champion
            {"--None Selected--", "Cast Down", "Divine Weapon", "Selective Energy", "Steady Spellcasting"}, //Cleric
            {"--None Selected--", "Green Empathy", "Insect Shape", "Steady Spellcasting", "Storm Retribution"}, //Druid
            {"--None Selected--", "Advanced Weapon Training", "Advantageous Assault", "Disarming Stance", "Furious Focus", "Guardian's Deflection", "Reflexive Shield", "Revealing Stab", "Shatter Defenses", "Shield Warden", "Triple Shot"}, //Fighter
            {"--None Selected--", "Abundant Step", "Crane Flutter", "Dragon Roar", "Ki Blast", "Mountain Stronghold", "Tiger Slash", "Water Slash", "Whirling Throw", "Wolf Drag"}, //Monk
            {"--None Selected--", "Mature Animal Companion", "Quick Snares", "Skirmish Strike", "Snap Shot", "Swift Tracker"}, //Ranger
            {"--None Selected--", "Gang Up", "Light Step", "Skirmish Strike", "Twist The Knife"}, //Rogue
            {"--None Selected--", "Advanced Bloodline", "Steady Spellcasting"}, //Sorcerer
            {"--None Selected--", "Spell Penetration", "Steady Spellcasting"} //Wizard
    };

    private final String[][] classFeats8 = {
            {"-"},
            {"--None Selected--", "Animal Rage", "Furious Bully", "Renewed Vigor", "Share Rage", "Sudden Leap", "Thrash"}, //Barbarian
            {"--None Selected--", "Eclectic Skill", "Inspire Heroics", "Know-It-All"}, //Bard
            {"--None Selected--", "Advanced Deity's Domain", "Greater Mercy", "Heal Mount", "Quick Shield Block", "Second Ally", "Sense Evil"}, //Champion
            {"--None Selected--", "Advanced Domain", "Align Armament", "Channeled Succor", "Cremate Undead", "Emblazon Energy"}, //Cleric
            {"--None Selected--", "Ferocious Shape", "Fey Caller", "Incredible Companion", "Soaring Shape", "Wind Caller"}, //Druid
            {"--None Selected--", "Blind-Fight", "Dualing Riposte", "Felling Strike", "Incredible Aim", "Mobile Shot", "Positioning Assault", "Quick Shield Block", "Sudden Leap"}, //Fighter
            {"--None Selected--", "Arrow Snatching", "Ironblood Stance", "Mixed Maneuver", "Tangled Forest-Stance", "Wall Run", "Wild Winds Initiate"}, //Monk
            {"--None Selected--", "Blind-Fight", "Deadly Aim", "Hazard Finder", "Powerful Snares", "Terrain Master", "Warden's Boon"}, //Ranger
            {"--None Selected--", "Blind-Fight", "Delay Trap", "Improved Poison Wepaon", "Nimble Roll", "Oppurtune Backstab", "Sidestep", "Sly Striker"}, //Rogue
            {"--None Selected--", "Bloodline Resistance", "Crossblooded Evolution"}, //Sorcerer
            {"--None Selected--", "Advanced School Spell", "Bond Conservation", "Universal Versatility"} //Wizard
    };

    private final String[][] classFeats10 = {
            {"-"},
            {"--None Selected--", "Come And Get Me", "Furious Sprint", "Great Cleave", "Knockback", "Terrifying Howl"}, //Barbarian
            {"--None Selected--", "House Of Imaginary Walls", "Quickened Casting", "Unusual Composition"}, //Bard
            {"--None Selected--", "Devoted Focus", "Imposing Destrier", "Litany Against Sloth", "Radiant Blade Spirit", "Shield Of Reckoning"}, //Champion
            {"--None Selected--", "Castigating Weapon", "Heroic Recovery", "Improved Command Undead", "Replenishment Of War"}, //Cleric
            {"--None Selected--", "Elemental Shape", "Healing Transformation", "Overwhelming Energy", "Plant Druid", "Side By Side"}, //Druid
            {"--None Selected--", "Agile Grace", "Certain Strike", "Combat Reflexes", "Debilitating Shot", "Disarming Twist", "Disruptive Stance", "Fearsome Brute", "Imrpoved Knockdown", "Mirror Shield", "Twin Riposte"}, //Fighter
            {"--None Selected--", "Knockback Strike", "Sleeper Hold", "Wind Jump", "Winding Flow"}, //Monk
            {"--None Selected--", "Camouflage", "Incredible Companion", "Master Monster Hunter", "Penatrating Shot", "Twin Riposte", "Warden's Step"}, //Ranger
            {"--None Selected--", "Precise Debilitations", "Sneak Savant", "Tactical Debilitations", "Vicious Debilitations"}, //Rogue
            {"--None Selected--", "Greater Bloodline", "Overwhelming Energy", "Quickened Casting"}, //Sorcerer
            {"--None Selected--", "Overwhelming Energy", "Quickened Casting", "Scroll Savant"} //Wizard
    };

    private final String[][] classFeats12 = {
            {"-"},
            {"--None Selected--", "Dragon's Rage Wings", "Furious Grab", "Predator's Pounce", "Spirit's Wrath", "Titan's Stature"}, //Barbarian
            {"--None Selected--", "Eclectic Polymath", "inspirational Focus"}, //Bard
            {"--None Selected--", "Affliction Mercy", "Aura Of Faith", "Blade Of Justice", "Champion's Sacrifice", "Divine Wall", "Lasting Doubt", "Liberating Stride"}, //Champion
            {"--None Selected--", "Defensive Recovery", "Domain Focus", "Emblazon Antimagic", "Shared Replenishment"}, //Cleric
            {"--None Selected--", "Dragon Shape", "Green Tongue", "Primal Focus", "Primal Summons"}, //Druid
            {"--None Selected--", "Brutal Finish", "Dueling Dance", "Flinging Shove", "Improved Dueling Riposte", "Incredible Ricochet", "Lunging Stance", "Paragon's Guard", "Spring Attack"}, //Fighter
            {"--None Selected--", "Diamond Soul", "Disrupt Ki", "Improved Knockback", "Meditative Focus", "Stance Savant"}, //Monk
            {"--None Selected--", "Distracting Shot", "Double Prey", "Lightening Snares", "Second Sting", "Side By Side"}, //Ranger
            {"--None Selected--", "Critical Debilitation", "Fantastic Leap", "Felling Shot", "Reactive Interference", "Spring From The Shadows"}, //Rogue
            {"--None Selected--", "Bloodline Focus", "Magic Sense"}, //Sorcerer
            {"--None Selected--", "Clever Counterspell", "Magic Sense"} //Wizard
    };

    private final String[][] classFeats14 = {
            {"-"},
            {"--None Selected--", "Awesome Blow", "Giant's Lunge", "Vengeful Strike", "Whirlwind Strike"}, //Barbarian
            {"--None Selected--", "Allegro", "Soothing Ballad", "True Hypercognition"}, //Bard
            {"--None Selected--", "Anchoring Aura", "Aura Of Life", "Aura Of Righteousness", "Aura Of Vengeance", "Divine Reflexes", "Litany Of Righteousness", "Wyrmbane Aura"}, //Champion
            {"--None Selected--", "Deity's Protection", "Extend Armament Alignment", "Fast Channel", "Swift Banishment"}, //Cleric
            {"--None Selected--", "Specialized Companion", "Timeless Nature", "Verdant Metamorphosis"}, //Druid
            {"--None Selected--", "Desperate Finisher", "Determination", "Guiding Finish", "Guiding Riposte", "Improved Twin Riposte", "Stance Savant", "Two-Weapon Flurry", "Whirlwind Strike"}, //Fighter
            {"--None Selected--", "Ironblood Surge", "Mountain Quake", "Tangled Forest Rake", "Timeless Body", "Tongue Of Sun And Moon", "Wild Winds Gust"}, //Monk
            {"--None Selected--", "Sense The Unseen", "Shared Prey", "Stealthy Companion", "Targeting Shot", "Warden's Guidance"}, //Ranger
            {"--None Selected--", "Defensive Roll", "Instant Opening", "Leave An Opening", "Sense The Unseen"}, //Rogue
            {"--None Selected--", "Interweave Dispel", "Reflect Spell"}, //Sorcerer
            {"--None Selected--", "Bonded Focus", "Reflect Spell", "Superior Bond"} //Wizard
    };

    private final String[][] classFeats16 = {
            {"-"},
            {"--None Selected--", "Collateral Thrash", "Dragon Transformation", "Reckless Abandon"}, //Barbarian
            {"--None Selected--", "Effortless Concentration", "Studious Capacity"}, //Bard
            {"--None Selected--", "Auspicious Mount", "Instrument Of Zeal", "Shield Of Grace"}, //Champion
            {"--None Selected--", "Eternal Bane", "Eternal Blessing", "Ressurectionist"}, //Cleric
            {"--None Selected--", "Effortless Concentration", "Impaling Briars", "Monstrosity Shape"}, //Druid
            {"--None Selected--", "Graceful Poise", "Improved Reflexive Shield", "Multishot Stance", "Twinned Defense"}, //Fighter
            {"--None Selected--", "Enlightening Presence", "Master Of Many Styles", "Quivering Palm", "Shattering Strike"}, //Monk
            {"--None Selected--", "Greater Distracting Shot", "Improved Twin Riposte", "Legendary Monster Hunter", "Specialized Companion", "Ubiquitous Snares"}, //Ranger
            {"--None Selected--", "Blank Slate", "Cloud Step", "Cognitive Loophole", "Dispelling Slice", "Perfect Distraction"}, //Rogue
            {"--None Selected--", "Effortless Concentration", "Greater Mental Evolution", "Greater Vital Evolution"}, //Sorcerer
            {"--None Selected--", "Effortless Concentration", "Spell Tinker"} //Wizard
    };

    private final String[][] classFeats18 = {
            {"-"},
            {"--None Selected--", "Brutal Critical", "Perfect Clarity", "Vicious Evisceration"}, //Barbarian
            {"--None Selected--", "Deep Lore", "Eternal Composition", "Impossible Polymath"}, //Bard
            {"--None Selected--", "Celestial Form", "Ultimate Mercy"}, //Champion
            {"--None Selected--", "Domain Wellspring", "Echoing Channel", "Improved Swift Banishment"}, //Cleric
            {"--None Selected--", "Invoke Disaster", "Perfect Form Control", "Primal Wellspring"}, //Druid
            {"--None Selected--", "Impossible Volley", "Savage Critical"}, //Fighter
            {"--None Selected--", "Diamond Fists", "Empty Body", "Meditative Wellspring", "Swift River"}, //Monk
            {"--None Selected--", "Impossible Flurry", "Impossible Volley", "Manifold Edge", "Masterful Companion", "Perfect Shot", "Shadow Hunter"}, //Ranger
            {"--None Selected--", "Implausible Infiltration", "Powerful Strike", "Trickster's Ace"}, //Rogue
            {"--None Selected--", "Bloodline Wellspring", "Greater Crossblooded Evolution"}, //Sorcerer
            {"--None Selected--", "Infinite Possibilities", "Reprepare Spell"} //Wizard
    };

    private final String[][] classFeats20 = {
            {"-"},
            {"--None Selected--", "Contagious Rage", "Quaking Stomp"}, //Barbarian
            {"--None Selected--", "Fatal Aria", "Perfect Encore", "Symphony Of The Muse"}, //Bard
            {"--None Selected--", "Celestial Mount", "Radiant Blade Master", "Shield Paragon"}, //Champion
            {"--None Selected--", "Avatar's Audience", "Maker Of Miracles", "Metamagic Channel"}, //Cleric
            {"--None Selected--", "Hierophant's Power", "Leyline Conduit", "True Shapeshifter"}, //Druid
            {"--None Selected--", "Boundless Reprisals", "Weapon Supremacy"}, //Fighter
            {"--None Selected--", "Enduring Quickness", "Fuse Stance", "Impossible Technique"}, //Monk
            {"--None Selected--", "Legendary Shot", "To The Ends Of The Earth", "Triple Threat", "Ultimate Skirmisher"}, //Ranger
            {"--None Selected--", "Hidden Paragon", "Impossible Striker", "Reactive Distraction"}, //Rogue
            {"--None Selected--", "Bloodline Conduit", "Bloodline Perfection", "Metamagic Mastery"}, //Sorcerer
            {"--None Selected--", "Archwizard's Might", "Metamagic Mastery", "Spell Combination"} //Wizard
    };

    private final String[][] classFeatures1 = {
            {"Rage", "Instinct"}, //Barbarian
            {"Occult Spellcasting", "Spell Repertoire (Bard)", "Composition Spells", "Muses"}, //Bard
            {"Champion's Code", "Deity And Cause", "Deific Weapon", "Champion's Reaction", "Devotion Spells", "Shield Block"}, //Champion
            {"Deity", "Divine Spellcasting", "Divine Font", "Doctrine"}, //Cleric
            {"Primal Spellcasting", "Anathema", "Druidic Language", "Druidic Order", "Shield Block", "Wild Empathy"}, //Druid
            {"Attack Of Opportunity", "Shield Block"}, //Fighter
            {"Flurry Of Blows", "Powerful Fist"}, //Monk
            {"Hunt Prey", "Hunter's Edge"}, //Ranger
            {"Rogue's Racket", "Sneak Attack", "Surprise Attack"}, //Rogue
            {"Bloodline", "Sorcerer Spellcasting", "Spell Repertoire (Sorcerer)"}, //Sorcerer
            {"Arcane Spellcasting", "Arcane School", "Arcane Bond", "Arcane Thesis"} //Wizard
    };

    private final String[][] classFeatures3 = {
            {"Deny Advantage"}, //Barbarian
            {"Lightning Reflexes", "Signature Spells"}, //Bard
            {"Divine Ally"}, //Champion
            {"None"}, //Cleric
            {"Alertness", "Great Fortitude"}, //Druid
            {"Bravery"}, //Fighter
            {"Incredible Movement", "Mystic Strikes"}, //Monk
            {"Iron Will"}, //Ranger
            {"Deny Advantage"}, //Rogue
            {"Signature Spells"}, //Sorcerer
            {"None"} //Wizard
    };

    private final String[][] classFeatures5 = {
            {"Brutality"}, //Barbarian
            {"None"}, //Bard
            {"Weapon Expertise"}, //Champion
            {"Alertness"}, //Cleric
            {"Lightning Reflexes"}, //Druid
            {"Fighter Weapon Mastery"}, //Fighter
            {"Alertness", "Expert Strikes"}, //Monk
            {"Ranger Weapon Expertise", "Trackless Step"}, //Ranger
            {"Weapon Tricks"}, //Rogue
            {"Magical Fortitude"}, //Sorcerer
            {"Lightning Reflexes"} //Wizard
    };

    private final String[][] classFeatures7 = {
            {"Juggernaut", "Weapon Specialization (Barbarian)"}, //Barbarian
            {"Expert Spellcaster"}, //Bard
            {"Armor Expertise", "Weapon Specialization"}, //Champion
            {"None"}, //Cleric
            {"Expert Spellcaster"}, //Druid
            {"Battlefield Surveyor", "Weapon Specialization"}, //Fighter
            {"Path To Perfection", "Weapon Specialization"}, //Monk
            {"Evasion", "Vigilant Senses", "Weapon Specialization"}, //Ranger
            {"Evasion", "Vigilant Senses", "Weapon Specialization"}, //Rogue
            {"Expert Spellcaster"}, //Sorcerer
            {"Expert Spellcaster"} //Wizard
    };

    private final String[][] classFeatures9 = {
            {"Lightning Reflexes", "Raging Resistance"}, //Barbarian
            {"Great Fortitude", "Resolve"}, //Bard
            {"Champion Expertise", "Divine Smite", "Juggernaut", "Lightning Reflexes"}, //Champion
            {"Resolve"}, //Cleric
            {"None"}, //Druid
            {"Combat Flexibility", "Juggernaut"}, //Fighter
            {"Metal Strikes", "Monk Expertise"}, //Monk
            {"Nature's Edge", "Ranger's Expertise"}, //Ranger
            {"Debilitating Strike", "Great Fortitude"}, //Rogue
            {"Lightning Reflexes"}, //Sorcerer
            {"Magical Fortitude"} //Wizard
            };

    private final String[][] classFeatures11 = {
            {"Mighty Rage"}, //Barbarian
            {"Bard Weapon Expertise", "Vigilant Senses"}, //Bard
            {"Alertness", "Divine Will", "Exalt"}, //Champion
            {"Lightning Reflexes"}, //Cleric
            {"Druid Weapon Expertise", "Resolve"}, //Druid
            {"Armor Expertise", "Fighter Expertise"}, //Fighter
            {"Second Path To Perfection"}, //Monk
            {"Juggernaut", "Medium Armor Expertise", "Wild Stride"}, //Ranger
            {"Rogue Expertise"}, //Rogue
            {"Alertness", "Weapon Expertise"}, //Sorcerer
            {"Alertness", "Wizard Weapon Expertise"} //Wizard
    };

    private final String[][] classFeatures13 = {
            {"Greater Juggernaut", "Medium Armor Expertise", "Weapon Fury"}, //Barbarian
            {"Light Armor Expertise", "Weapon Specialization"}, //Bard
            {"Armor Mastery", "Weapon Mastery"}, //Champion
            {"Divine Defense", "Weapon Specialization"}, //Cleric
            {"Medium Armor Expertise", "Weapon Specialization"}, //Druid
            {"Weapon Legend"}, //Fighter
            {"Graceful Mastery", "Master Strikes"}, //Monk
            {"Weapon Mastery"}, //Ranger
            {"Improved Evasion", "Incredible Senses", "Light Armor Expertise", "Master Tricks"}, //Rogue
            {"Defensive Robes", "Weapon Specialization"}, //Sorcerer
            {"Defensive Robes", "Weapon Specialization"} //Wizard
            };

    private final String[][] classFeatures15 = {
            {"Greater Weapon Specialization", "Indomitable Will"}, //Barbarian
            {"Master Spellcaster"}, //Bard
            {"Greater Weapon Specialization"}, //Champion
            {"None"}, //Cleric
            {"Master Spellcaster"}, //Druid
            {"Evasion", "Greater Weapon Specialization", "Improved Flexibility"}, //Fighter
            {"Greater Weapon Specialization", "Third Path To Perfection"}, //Monk
            {"Greater Weapon Specialization", "Improved Evasion", "Incredible Senses"}, //Ranger
            {"Double Debilitation", "Greater Weapon Specialization"}, //Rogue
            {"Master Spellcaster"}, //Sorcerer
            {"Master Spellcaster"} //Wizard
            };

    private final String[][] classFeatures17 = {
            {"Heightened Senses", "Quick Rage"}, //Barbarian
            {"Greater Resolve"}, //Bard
            {"Champion Mastery", "Legendary Armor"}, //Champion
            {"None"}, //Cleric
            {"None"}, //Druid
            {"Armor Mastery"}, //Fighter
            {"Adamantine Strikes", "Graceful Legend"}, //Monk
            {"Masterful Hunter"}, //Ranger
            {"Slippery Mind"}, //Rogue
            {"Resolve"}, //Sorcerer
            {"Resolve"} //Wizard
    };

    private final String[][] classFeatures19 = {
            {"Armor of Fury", "Devastator"}, //Barbarian
            {"Magnum Opus", "Legendary Spellcaster"}, //Bard
            {"Hero's Defiance"}, //Champion
            {"Miraculous Spell"}, //Cleric
            {"Legendary Spellcaster", "Primal Hierophant"}, //Druid
            {"Versatile Legend"}, //Fighter
            {"Perfected Form"}, //Monk
            {"Second Skin", "Swift Prey"}, //Ranger
            {"Light Armor Mastery", "Master Strike"}, //Rogue
            {"Bloodline Paragon", "Legendary Spellcaster"}, //Sorcerer
            {"Archwizard's Spellcraft", "Legendary Spellcaster"} //Wizard
            };

    private final String [] generalFeats = {
            "--None Selected--", "Adopted Ancestry", "Armor Proficiency", "Breath Control", "Canny Acumen", "Diehard", "Fast Recovery", "Feather Step", "Fleet", "Incredible Initiative", "Ride", "Shield Block", "Toughness", "Weapon Proficiency", "Ancestral Paragon", "Untrained Improvisation", "Expiditious Search", "Incredible Investiture", // General
            "Assurance", "Dubious Knowledge", "Quick Identification", "Recognize Spell", "Skill Training", "Trick Magic Item", "Automatic Knowledge", "Magical Shorthand", "Quick Recognition", // General Skill Feats
    };

    private final String [] generalSkillFeats = {
            "--None Selected--", "Assurance", "Dubious Knowledge", "Quick Identification", "Recognize Spell", "Skill Training", "Trick Magic Item", "Automatic Knowledge", "Magical Shorthand", "Quick Recognition", // General Skill Feats
            "Cat Fall", "Quick Squeeze", "Steady Balance", "Nimble Crawl", "Kip Up", // Acrobatics
            "Arcane Sense", "Unified Theory", // Arcana
            "Combat Climber", "Hefty Hauler", "Quick Jump", "Titan Wrestler", "Underwater Marauder", "Powerful Leap", "Rapid Mantel", "Quick Climb", "Quick Swim", "Wall Jump", "Cloud Jump", // Athletics
            "Alchemical Crafting", "Quick Repair", "Snare Crafting" ,"Specialty Crafting", "Magical Crafting", "Inventor", "Craft Anything", // Crafting
            "Charming Liar", "Lengthy Diversion", "Lie To Me", "Confabulator", "Quick Disguise", "Slippery Secrets", // Deception
            "Bargain Hunter", "Group Impression", "Hobnobber", "Glad-Hand", "Shameless Request", "Legendary Negotiation", // Diplomacy
            "Group Coercion", "Intimidating Glare", "Quick Coercion", "Intimidating Prowess", "Lasting Coercion", "Battle Cry", "Terrified Retreat", "Scare To Death", // Intimidation
            "Additional Lore", "Experienced Professional", "Unmistakable Lore", "Legendary Professional", // Lore
            "Battle Medicine", "Continual Recovery", "Robust Recovery", "Ward Medic", "Legendary Medic", // Medicine
            "Natural Medicine", "Train Animal", "Bonded Animal", // Nature
            "Oddity Identification", "Bizarre Magic", // Occultism
            "Fascinating Performance", "Impressive Performance", "Virtuosic Performer", "Legendary Performer", //Performance
            "Student Of The Canon", "Divine Guidance", // Religion
            "Courtly Graces", "Multilingual", "Read Lips", "Sign Language", "Streetwise", "Connections", "Legendary Codebreaker", "Legendary Linguist", // Society
            "Experienced Smuggler", "Terrain Stalker", "Quiet Allies", "Foil Senses", "Swift Sneak", "Legendary Sneak", // Stealth
            "Experienced Tracker", "Forager", "Survey Wildlife", "Terrain Expertise" ,"Planar Survival", "Legendary Survivalist", // Survival
            "Pickpocket", "Subtle Theft", "Wary Disarmament", "Quick Unlock", "Legendary Thief" // Thievery
    };
    private final String[] backgrounds = {"-- None Selected--", "Acolyte", "Artisan", "Barrister", "Bounty Hunter", "Criminal", "Entertainer", "Guard", "Herbalist", "Merchant", "Sailor", "Scholar", "Warrior"};

    public PathfinderCharacterCreator() {
        // Function to serve as the main creator of the Creation Window
        // Written by Ryan Janis
        // February 2024
        // Language: Java

        setTitle("Pathfinder Character Creator");
        setSize(1050, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        if (askToLoadCharacter()) {
            loadCharacter();
        } else {
            initializeComponents();
        }
    }

    private boolean askToLoadCharacter() {
        // Function to show a dialog window on whether the user would like to load a previously saved character or create a new one
        // Written by Ryan Janis
        // February 2024
        // Language: Java

        int choice = JOptionPane.showConfirmDialog(this,
                "Do you want to load a previously saved character?",
                "Load Character", JOptionPane.YES_NO_OPTION);
        return choice == JOptionPane.YES_OPTION;
    }

    private void addReadOnlyTextBox(JPanel panel, String text) {
        // Function to add a read only text box into a JPanel
        // Written by Ryan Janis
        // March 2024
        // Language: Java

        JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField textField = new JTextField(text);
        textField.setEditable(false);
        rowPanel.add(textField);
        panel.add(rowPanel);
    }
    private void initializeComponents() {
        // Function to initialize all the panels and other components of the creator. It also houses many actionListeners to have the program change in ways it otherwise couldn't
        // Written by Ryan Janis
        // February 2024. Modified March, April, May 2024
        // Language: Java

        // Main panel for holding all components
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Panel for displaying class information
        JPanel classInfoPanel = new JPanel(new BorderLayout());
        JTextArea classInfoTextArea = new JTextArea();
        classInfoTextArea.setEditable(false);
        classInfoTextArea.setLineWrap(true);
        classInfoTextArea.setWrapStyleWord(true);
        classInfoPanel.setPreferredSize(new Dimension(300, 700));
        JScrollPane classScrollPane = new JScrollPane(classInfoTextArea);
        classScrollPane.setPreferredSize(new Dimension(300, 150)); // Set preferred size
        classInfoPanel.add(classScrollPane, BorderLayout.CENTER);

        // Initially hide the class info panel
        classInfoPanel.setVisible(false);

        // Panel for holding feat information
        JPanel featInfoPanel = new JPanel(new BorderLayout());
        JTextArea featInfoTextArea = new JTextArea();
        featInfoTextArea.setEditable(false);
        featInfoTextArea.setLineWrap(true);
        featInfoTextArea.setWrapStyleWord(true);
        featInfoPanel.setPreferredSize(new Dimension(300, 700));
        JScrollPane featScrollPane = new JScrollPane(featInfoTextArea);
        featScrollPane.setPreferredSize(new Dimension(300, 250)); // Set preferred size
        featInfoPanel.add(featScrollPane, BorderLayout.CENTER);

        // Initially hide the feat info panel
        featInfoPanel.setVisible(false);

        // Panel for selection components
        JPanel selectionPanel = new JPanel(new BorderLayout());
        selectionPanel.setLayout(new BoxLayout(selectionPanel, BoxLayout.Y_AXIS));
        JScrollPane selectionScrollPane = new JScrollPane(selectionPanel);
        selectionScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JScrollBar selectionScrollBar = selectionScrollPane.getVerticalScrollBar();
        selectionScrollBar.setUnitIncrement(15);

        ////////////////////////////////////////////////////
        // Initialize the actual components in the creator//
        ////////////////////////////////////////////////////
        addComponent(selectionPanel, "Character Name:", characterNameField = new JTextField(20));
        addComponent(selectionPanel, "Ancestry:", ancestryComboBox = new JComboBox<>(ancestries));
        addComponent(selectionPanel, "Heritage:", heritageComboBox = new JComboBox<>(heritages[0]));
        addComponent(selectionPanel, "Background:", backgroundComboBox = new JComboBox<>(backgrounds));
        addComponent(selectionPanel, "Level:", levelComboBox = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}));

        addComponent(selectionPanel, "Class:", classComboBox = new JComboBox<>(classes));
        addLabel(selectionPanel, new JLabel("<html><body style='width: 275px'>To apply an ability boost or flaw, add or remove 2 from the following values respectively:</body></html>"));
        addAbilityComponent(selectionPanel, "Strength:      ", strField = new JTextField(2), "Strength Modifier:        ");
        addAbilityComponent(selectionPanel, "Dexterity:      ", dexField = new JTextField(2), "Dexterity Modifier:       ");
        addAbilityComponent(selectionPanel, "Constitution:", conField = new JTextField(2), "Constitution Modifier: ");
        addAbilityComponent(selectionPanel, "Intelligence: ", intField = new JTextField(2), "Intelligence Modifier:  ");
        addAbilityComponent(selectionPanel, "Wisdom:       ", wisField = new JTextField(2), "Wisdom Modifier:        ");
        addAbilityComponent(selectionPanel, "Charisma:    ", chaField = new JTextField(2), "Charisma Modifier:      ");

        strField.setText("10");
        dexField.setText("10");
        conField.setText("10");
        intField.setText("10");
        wisField.setText("10");
        chaField.setText("10");
            // Add Label to denote Ability Boost Rules
        addLabel(selectionPanel, new JLabel("<html><body style='width: 275px'>Once you have finished applying your ability boosts from your ancestry, background, and class, apply 4 more which must be applied to one ability each.<br />At 5th level and every 5 levels thereafter you get a free ability boost. When applying a boost to an ability with a score of at least 18, it only increases your score by 1 instead of 2.</body></html>"));
        addSkill(selectionPanel, "Acrobatics:    ", acrobatics);
        addSkill(selectionPanel, "Arcana:           ", arcana);
        addSkill(selectionPanel, "Athletics:       ", athletics);
        addSkill(selectionPanel, "Crafting:         ", crafting);
        addSkill(selectionPanel, "Deception:      ", deception);
        addSkill(selectionPanel, "Diplomacy:     ", diplomacy);
        addSkill(selectionPanel, "Intimidation:   ", intimidation);
        addSkill(selectionPanel, "Medicine:        ", medicine);
        addSkill(selectionPanel, "Nature:            ", nature);
        addSkill(selectionPanel, "Occultism:      ", occultism);
        addSkill(selectionPanel, "Performance:", performance);
        addSkill(selectionPanel, "Religion:          ", religion);
        addSkill(selectionPanel, "Society:           ", society);
        addSkill(selectionPanel, "Stealth:            ", stealth);
        addSkill(selectionPanel, "Survival:          ", survival);
        addSkill(selectionPanel, "Thievery:         ", thievery);

        // Add Label to denote Skill Increase rules
        addLabel(selectionPanel, new JLabel("<html><body style='width: 275px'>At 3rd level and every other level afterwards you may choose an additional skill to become trained in or you may choose a skill you are trained in to become an expert. Once you reach 7th level you may choose to upgrade an expert skill to master, and at 15th you may choose a master skill to upgrade to legendary.</body></html>"));

        // Level 1
        addReadOnlyTextBox(selectionPanel, "Level: 1");
        addLabel(selectionPanel, classFeaturesLabel1 = new JLabel());
        addComponent(selectionPanel, "Ancestry Feat 1", ancestryFeats1ComboBox = new JComboBox<>(ancestryFeats1[0]));
        addComponent(selectionPanel, "Class Feat 1:", featClass1ComboBox = new JComboBox<>(classFeats1[0]));

        // Level 2
        addReadOnlyTextBox(selectionPanel, "Level: 2");
        addComponent(selectionPanel, "Skill Feat 2:", featSkill2ComboBox = new JComboBox<>(generalSkillFeats));
        addComponent(selectionPanel, "Class Feat 2:", featClass2ComboBox = new JComboBox<>(classFeats2[0]));
            featSkill2ComboBox.setVisible(false);
            featClass2ComboBox.setVisible(false);
        // Level 3
        addReadOnlyTextBox(selectionPanel, "Level: 3");
        addLabel(selectionPanel, classFeaturesLabel3 = new JLabel());
        addComponent(selectionPanel, "General Feat 3:", featGeneral3ComboBox = new JComboBox<>(generalFeats));
            classFeaturesLabel3.setVisible(false);
            featGeneral3ComboBox.setVisible(false);
        // Level 4
        addReadOnlyTextBox(selectionPanel, "Level: 4");
        addComponent(selectionPanel, "Skill Feat 4:", featSkill4ComboBox = new JComboBox<>(generalSkillFeats));
        addComponent(selectionPanel, "Class Feat 4:", featClass4ComboBox = new JComboBox<>(classFeats4[0]));
            featSkill4ComboBox.setVisible(false);
            featClass4ComboBox.setVisible(false);
        // Level 5
        addReadOnlyTextBox(selectionPanel, "Level: 5");
        addComponent(selectionPanel, "Ancestry Feat 5", ancestryFeats5ComboBox = new JComboBox<>(ancestryFeats5[0]));
        addLabel(selectionPanel, classFeaturesLabel5 = new JLabel());
            ancestryFeats5ComboBox.setVisible(false);
            classFeaturesLabel5.setVisible(false);
        // Level 6
        addReadOnlyTextBox(selectionPanel, "Level: 6");
        addComponent(selectionPanel, "Skill Feat 6:", featSkill6ComboBox = new JComboBox<>(generalSkillFeats));
        addComponent(selectionPanel, "Class Feat 6:", featClass6ComboBox = new JComboBox<>(classFeats6[0]));
            featSkill6ComboBox.setVisible(false);
            featClass6ComboBox.setVisible(false);
        // Level 7
        addReadOnlyTextBox(selectionPanel, "Level: 7");
        addLabel(selectionPanel, classFeaturesLabel7 = new JLabel());
        addComponent(selectionPanel, "General Feat 7:", featGeneral7ComboBox = new JComboBox<>(generalFeats));
            classFeaturesLabel7.setVisible(false);
            featGeneral7ComboBox.setVisible(false);
        // Level 8
        addReadOnlyTextBox(selectionPanel, "Level: 8");
        addComponent(selectionPanel, "Skill Feat 8:", featSkill8ComboBox = new JComboBox<>(generalSkillFeats));
        addComponent(selectionPanel, "Class Feat 8:", featClass8ComboBox = new JComboBox<>(classFeats8[0]));
            featSkill8ComboBox.setVisible(false);
            featClass8ComboBox.setVisible(false);
        // Level 9
        addReadOnlyTextBox(selectionPanel, "Level: 9");
        addComponent(selectionPanel, "Ancestry Feat 9", ancestryFeats9ComboBox = new JComboBox<>(ancestryFeats9[0]));
        addLabel(selectionPanel, classFeaturesLabel9 = new JLabel());
            ancestryFeats9ComboBox.setVisible(false);
            classFeaturesLabel9.setVisible(false);
        // Level 10
        addReadOnlyTextBox(selectionPanel, "Level: 10");
        addComponent(selectionPanel, "Skill Feat 10:", featSkill10ComboBox = new JComboBox<>(generalSkillFeats));
        addComponent(selectionPanel, "Class Feat 10:", featClass10ComboBox = new JComboBox<>(classFeats10[0]));
            featSkill10ComboBox.setVisible(false);
            featClass10ComboBox.setVisible(false);
        // Level 11
        addReadOnlyTextBox(selectionPanel, "Level: 11");
        addLabel(selectionPanel, classFeaturesLabel11 = new JLabel());
        addComponent(selectionPanel, "General Feat 11:", featGeneral11ComboBox = new JComboBox<>(generalFeats));
            classFeaturesLabel11.setVisible(false);
            featGeneral11ComboBox.setVisible(false);
        // Level 12
        addReadOnlyTextBox(selectionPanel, "Level: 12");
        addComponent(selectionPanel, "Skill Feat 12:", featSkill12ComboBox = new JComboBox<>(generalSkillFeats));
        addComponent(selectionPanel, "Class Feat 12:", featClass12ComboBox = new JComboBox<>(classFeats12[0]));
            featSkill12ComboBox.setVisible(false);
            featClass12ComboBox.setVisible(false);
        // Level 13
        addReadOnlyTextBox(selectionPanel, "Level: 13");
        addComponent(selectionPanel, "Ancestry Feat 13:", ancestryFeats13ComboBox = new JComboBox<>(ancestryFeats13[0]));
        addLabel(selectionPanel, classFeaturesLabel13 = new JLabel());
            ancestryFeats13ComboBox.setVisible(false);
            classFeaturesLabel13.setVisible(false);
        // Level 14
        addReadOnlyTextBox(selectionPanel, "Level: 14");
        addComponent(selectionPanel, "Skill Feat 14:", featSkill14ComboBox = new JComboBox<>(generalSkillFeats));
        addComponent(selectionPanel, "Class Feat 14:", featClass14ComboBox = new JComboBox<>(classFeats14[0]));
            featSkill14ComboBox.setVisible(false);
            featClass14ComboBox.setVisible(false);
        // Level 15
        addReadOnlyTextBox(selectionPanel, "Level: 15");
        addLabel(selectionPanel, classFeaturesLabel15 = new JLabel());
        addComponent(selectionPanel, "General Feat 15:", featGeneral15ComboBox = new JComboBox<>(generalFeats));
            classFeaturesLabel15.setVisible(false);
            featGeneral15ComboBox.setVisible(false);
        // Level 16
        addReadOnlyTextBox(selectionPanel, "Level: 16");
        addComponent(selectionPanel, "Skill Feat 16:", featSkill16ComboBox = new JComboBox<>(generalSkillFeats));
        addComponent(selectionPanel, "Class Feat 16:", featClass16ComboBox = new JComboBox<>(classFeats16[0]));
            featSkill16ComboBox.setVisible(false);
            featClass16ComboBox.setVisible(false);
        // Level 17
        addReadOnlyTextBox(selectionPanel, "Level: 17");
        addLabel(selectionPanel, classFeaturesLabel17 = new JLabel());
            classFeaturesLabel17.setVisible(false);
        // Level 18
        addReadOnlyTextBox(selectionPanel, "Level: 18");
        addComponent(selectionPanel, "Skill Feat 18:", featSkill18ComboBox = new JComboBox<>(generalSkillFeats));
        addComponent(selectionPanel, "Class Feat 18:", featClass18ComboBox = new JComboBox<>(classFeats18[0]));
            featSkill18ComboBox.setVisible(false);
            featClass18ComboBox.setVisible(false);
        // Level 19
        addReadOnlyTextBox(selectionPanel, "Level: 19");
        addLabel(selectionPanel, classFeaturesLabel19 = new JLabel());
        addComponent(selectionPanel, "General Feat 19:", featGeneral19ComboBox = new JComboBox<>(generalFeats));
            classFeaturesLabel19.setVisible(false);
            featGeneral19ComboBox.setVisible(false);
        // Level 20
        addReadOnlyTextBox(selectionPanel, "Level: 20");
        addComponent(selectionPanel, "Skill Feat 20:", featSkill20ComboBox = new JComboBox<>(generalSkillFeats));
        addComponent(selectionPanel, "Class Feat 20:", featClass20ComboBox = new JComboBox<>(classFeats20[0]));
            featSkill20ComboBox.setVisible(false);
            featClass20ComboBox.setVisible(false);

        // Add selection panel to the main panel
        mainPanel.add(selectionPanel, BorderLayout.CENTER);

        // Add main,featInfo, and classInfo panels to the frame
        add(mainPanel, BorderLayout.CENTER);
        add(featInfoPanel, BorderLayout.WEST);
        add(classInfoPanel, BorderLayout.EAST);

        JScrollPane scrollPane = new JScrollPane(selectionPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setUnitIncrement(15);
        getContentPane().add(scrollPane);

        // Add Button panel
        JPanel southPanel = new JPanel(new GridLayout(1,0));

        // Add save button
        JButton saveButton = new JButton("Save Character");
        southPanel.add(saveButton);

        // Add Display open button
        JButton openDisplay = new JButton("Open Display");
        southPanel.add(openDisplay);

        add(southPanel, BorderLayout.SOUTH);

        // Trys to read in from all the info files
        try {
            readFeatInfoFromFile("ancestryFeats_info.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            readFeatInfoFromFile("background_info.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            readClassInfoFromFile("class_info.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            readFeatInfoFromFile("classFeats1_info.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            readFeatInfoFromFile("classFeats2_info.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            readFeatInfoFromFile("classFeats4_info.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            readFeatInfoFromFile("classFeats6_info.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            readFeatInfoFromFile("classFeats8_info.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            readFeatInfoFromFile("classFeats10_info.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            readFeatInfoFromFile("classFeats12_info.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            readFeatInfoFromFile("classFeats14_info.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            readFeatInfoFromFile("classFeats16_info.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            readFeatInfoFromFile("classFeats18_info.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            readFeatInfoFromFile("classFeats20_info.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            readFeatInfoFromFile("generalSkillFeats_info.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            readFeatureInfoFromFile("classFeatures_info.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        ancestryComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedAncestry = (String) ancestryComboBox.getSelectedItem();
                String ancestryInfo = featInfoMap.get(selectedAncestry);
                int selectedAncestryIndex = ancestryComboBox.getSelectedIndex();
                if (ancestryInfo != null) {
                    //Display ancestry specific heritages
                    heritageComboBox.setModel(new DefaultComboBoxModel<>(heritages[selectedAncestryIndex]));
                    ancestryFeats1ComboBox.setModel(new DefaultComboBoxModel<>(ancestryFeats1[selectedAncestryIndex]));
                    ancestryFeats5ComboBox.setModel(new DefaultComboBoxModel<>(ancestryFeats5[selectedAncestryIndex]));
                    ancestryFeats9ComboBox.setModel(new DefaultComboBoxModel<>(ancestryFeats9[selectedAncestryIndex]));
                    ancestryFeats13ComboBox.setModel(new DefaultComboBoxModel<>(ancestryFeats13[selectedAncestryIndex]));
                    featInfoTextArea.setText(ancestryInfo);
                    featInfoPanel.setVisible(true);
                } else {
                    System.out.println("No specific information available for " + selectedAncestry);
                }
            }
        });

        classComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedClass = (String) classComboBox.getSelectedItem();
                String classInfo = classInfoMap.get(selectedClass);
                int selectedClassIndex = classComboBox.getSelectedIndex();
                if (classInfo != null) {
                    // Display class specific feat options
                    featClass1ComboBox.setModel(new DefaultComboBoxModel<>(classFeats1[selectedClassIndex]));
                    featClass2ComboBox.setModel(new DefaultComboBoxModel<>(classFeats2[selectedClassIndex]));
                    featClass4ComboBox.setModel(new DefaultComboBoxModel<>(classFeats4[selectedClassIndex]));
                    featClass6ComboBox.setModel(new DefaultComboBoxModel<>(classFeats6[selectedClassIndex]));
                    featClass8ComboBox.setModel(new DefaultComboBoxModel<>(classFeats8[selectedClassIndex]));
                    featClass10ComboBox.setModel(new DefaultComboBoxModel<>(classFeats10[selectedClassIndex]));
                    featClass12ComboBox.setModel(new DefaultComboBoxModel<>(classFeats12[selectedClassIndex]));
                    featClass14ComboBox.setModel(new DefaultComboBoxModel<>(classFeats14[selectedClassIndex]));
                    featClass16ComboBox.setModel(new DefaultComboBoxModel<>(classFeats16[selectedClassIndex]));
                    featClass18ComboBox.setModel(new DefaultComboBoxModel<>(classFeats18[selectedClassIndex]));
                    featClass20ComboBox.setModel(new DefaultComboBoxModel<>(classFeats20[selectedClassIndex]));
                    classInfoTextArea.setText(classInfo);
                    classInfoPanel.setVisible(true);
                    classFeaturesLabel1.setText(displayFeatures(0, selectedClassIndex));
                    classFeaturesLabel3.setText(displayFeatures(1, selectedClassIndex));
                    classFeaturesLabel5.setText(displayFeatures(2, selectedClassIndex));
                    classFeaturesLabel7.setText(displayFeatures(3, selectedClassIndex));
                    classFeaturesLabel9.setText(displayFeatures(4, selectedClassIndex));
                    classFeaturesLabel11.setText(displayFeatures(5, selectedClassIndex));
                    classFeaturesLabel13.setText(displayFeatures(6, selectedClassIndex));
                    classFeaturesLabel15.setText(displayFeatures(7, selectedClassIndex));
                    classFeaturesLabel17.setText(displayFeatures(8, selectedClassIndex));
                    classFeaturesLabel19.setText(displayFeatures(9, selectedClassIndex));

                } else {
                    // Handle the case when no specific information is available for the selected class
                    System.out.println("No specific information available for " + selectedClass);
                }
            }
        });

        backgroundComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFeat = (String) backgroundComboBox.getSelectedItem();
                String featInfo = featInfoMap.get(selectedFeat);
                if (featInfo != null) {
                    featInfoTextArea.setText(featInfo);
                    featInfoPanel.setVisible(true);
                } else {
                    // Handle the case when no specific information is available for the selected feat
                    System.out.println("No specific information available for " + selectedFeat);
                }
            }
        });

        levelComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the selected level from the combo box
                int selectedLevel = (int) levelComboBox.getSelectedItem();

                // Update visibility based on the selected level
                updateFeaturesVisibility(selectedLevel);
            }
        });

        // Action listeners for each ancestry feat box
        heritageComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedHeritage = (String) heritageComboBox.getSelectedItem();
                String heritageInfo = featInfoMap.get(selectedHeritage);
                if (heritageInfo != null) {
                    featInfoTextArea.setText(heritageInfo);
                    featInfoPanel.setVisible(true);
                } else {
                    // Handle the case when no specific information is available for the selected feat
                    System.out.println("No specific information available for " + selectedHeritage);
                }
            }
        });

        ancestryFeats1ComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedAncestry = (String) ancestryFeats1ComboBox.getSelectedItem();
                String ancestryInfo = featInfoMap.get(selectedAncestry);
                if (ancestryInfo != null) {
                    featInfoTextArea.setText(ancestryInfo);
                    featInfoPanel.setVisible(true);
                } else {
                    // Handle the case when no specific information is available for the selected feat
                    System.out.println("No specific information available for " + selectedAncestry);
                }
            }
        });

        ancestryFeats5ComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedAncestry = (String) ancestryFeats5ComboBox.getSelectedItem();
                String ancestryInfo = featInfoMap.get(selectedAncestry);
                if (ancestryInfo != null) {
                    featInfoTextArea.setText(ancestryInfo);
                    featInfoPanel.setVisible(true);
                } else {
                    // Handle the case when no specific information is available for the selected feat
                    System.out.println("No specific information available for " + selectedAncestry);
                }
            }
        });

        ancestryFeats9ComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedAncestry = (String) ancestryFeats9ComboBox.getSelectedItem();
                String ancestryInfo = featInfoMap.get(selectedAncestry);
                if (ancestryInfo != null) {
                    featInfoTextArea.setText(ancestryInfo);
                    featInfoPanel.setVisible(true);
                } else {
                    // Handle the case when no specific information is available for the selected feat
                    System.out.println("No specific information available for " + selectedAncestry);
                }
            }
        });

        ancestryFeats13ComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedAncestry = (String) ancestryFeats13ComboBox.getSelectedItem();
                String ancestryInfo = featInfoMap.get(selectedAncestry);
                if (ancestryInfo != null) {
                    featInfoTextArea.setText(ancestryInfo);
                    featInfoPanel.setVisible(true);
                } else {
                    // Handle the case when no specific information is available for the selected feat
                    System.out.println("No specific information available for " + selectedAncestry);
                }
            }
        });


        // Action listeners for each class feat box
        featClass1ComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFeat = (String) featClass1ComboBox.getSelectedItem();
                String featInfo = featInfoMap.get(selectedFeat);
                if (featInfo != null) {
                    featInfoTextArea.setText(featInfo);
                    featInfoPanel.setVisible(true);
                } else {
                    // Handle the case when no specific information is available for the selected feat
                    System.out.println("No specific information available for " + selectedFeat);
                }
            }
        });

        featClass2ComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFeat = (String) featClass2ComboBox.getSelectedItem();
                String featInfo = featInfoMap.get(selectedFeat);
                if (featInfo != null) {
                    featInfoTextArea.setText(featInfo);
                    featInfoPanel.setVisible(true);
                } else {
                    // Handle the case when no specific information is available for the selected feat
                    System.out.println("No specific information available for " + selectedFeat);
                }
            }
        });

        featClass4ComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFeat = (String) featClass4ComboBox.getSelectedItem();
                String featInfo = featInfoMap.get(selectedFeat);
                if (featInfo != null) {
                    featInfoTextArea.setText(featInfo);
                    featInfoPanel.setVisible(true);
                } else {
                    // Handle the case when no specific information is available for the selected feat
                    System.out.println("No specific information available for " + selectedFeat);
                }
            }
        });

        featClass6ComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFeat = (String) featClass6ComboBox.getSelectedItem();
                String featInfo = featInfoMap.get(selectedFeat);
                if (featInfo != null) {
                    featInfoTextArea.setText(featInfo);
                    featInfoPanel.setVisible(true);
                } else {
                    // Handle the case when no specific information is available for the selected feat
                    System.out.println("No specific information available for " + selectedFeat);
                }
            }
        });

        featClass8ComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFeat = (String) featClass8ComboBox.getSelectedItem();
                String featInfo = featInfoMap.get(selectedFeat);
                if (featInfo != null) {
                    featInfoTextArea.setText(featInfo);
                    featInfoPanel.setVisible(true);
                } else {
                    // Handle the case when no specific information is available for the selected feat
                    System.out.println("No specific information available for " + selectedFeat);
                }
            }
        });

        featClass10ComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFeat = (String) featClass10ComboBox.getSelectedItem();
                String featInfo = featInfoMap.get(selectedFeat);
                if (featInfo != null) {
                    featInfoTextArea.setText(featInfo);
                    featInfoPanel.setVisible(true);
                } else {
                    // Handle the case when no specific information is available for the selected feat
                    System.out.println("No specific information available for " + selectedFeat);
                }
            }
        });

        featClass12ComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFeat = (String) featClass12ComboBox.getSelectedItem();
                String featInfo = featInfoMap.get(selectedFeat);
                if (featInfo != null) {
                    featInfoTextArea.setText(featInfo);
                    featInfoPanel.setVisible(true);
                } else {
                    // Handle the case when no specific information is available for the selected feat
                    System.out.println("No specific information available for " + selectedFeat);
                }
            }
        });

        featClass14ComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFeat = (String) featClass14ComboBox.getSelectedItem();
                String featInfo = featInfoMap.get(selectedFeat);
                if (featInfo != null) {
                    featInfoTextArea.setText(featInfo);
                    featInfoPanel.setVisible(true);
                } else {
                    // Handle the case when no specific information is available for the selected feat
                    System.out.println("No specific information available for " + selectedFeat);
                }
            }
        });

        featClass16ComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFeat = (String) featClass16ComboBox.getSelectedItem();
                String featInfo = featInfoMap.get(selectedFeat);
                if (featInfo != null) {
                    featInfoTextArea.setText(featInfo);
                    featInfoPanel.setVisible(true);
                } else {
                    // Handle the case when no specific information is available for the selected feat
                    System.out.println("No specific information available for " + selectedFeat);
                }
            }
        });

        featClass18ComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFeat = (String) featClass18ComboBox.getSelectedItem();
                String featInfo = featInfoMap.get(selectedFeat);
                if (featInfo != null) {
                    featInfoTextArea.setText(featInfo);
                    featInfoPanel.setVisible(true);
                } else {
                    // Handle the case when no specific information is available for the selected feat
                    System.out.println("No specific information available for " + selectedFeat);
                }
            }
        });

        featClass20ComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFeat = (String) featClass20ComboBox.getSelectedItem();
                String featInfo = featInfoMap.get(selectedFeat);
                if (featInfo != null) {
                    featInfoTextArea.setText(featInfo);
                    featInfoPanel.setVisible(true);
                } else {
                    // Handle the case when no specific information is available for the selected feat
                    System.out.println("No specific information available for " + selectedFeat);
                }
            }
        });

        // Action listeners for each general feat box
        featGeneral3ComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFeat = (String) featGeneral3ComboBox.getSelectedItem();
                String featInfo = featInfoMap.get(selectedFeat);
                if (featInfo != null) {
                    featInfoTextArea.setText(featInfo);
                    featInfoPanel.setVisible(true);
                } else {
                    // Handle the case when no specific information is available for the selected feat
                    System.out.println("No specific information available for " + selectedFeat);
                }
            }
        });

        featGeneral7ComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFeat = (String) featGeneral7ComboBox.getSelectedItem();
                String featInfo = featInfoMap.get(selectedFeat);
                if (featInfo != null) {
                    featInfoTextArea.setText(featInfo);
                    featInfoPanel.setVisible(true);
                } else {
                    // Handle the case when no specific information is available for the selected feat
                    System.out.println("No specific information available for " + selectedFeat);
                }
            }
        });

        featGeneral11ComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFeat = (String) featGeneral11ComboBox.getSelectedItem();
                String featInfo = featInfoMap.get(selectedFeat);
                if (featInfo != null) {
                    featInfoTextArea.setText(featInfo);
                    featInfoPanel.setVisible(true);
                } else {
                    // Handle the case when no specific information is available for the selected feat
                    System.out.println("No specific information available for " + selectedFeat);
                }
            }
        });

        featGeneral15ComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFeat = (String) featGeneral15ComboBox.getSelectedItem();
                String featInfo = featInfoMap.get(selectedFeat);
                if (featInfo != null) {
                    featInfoTextArea.setText(featInfo);
                    featInfoPanel.setVisible(true);
                } else {
                    // Handle the case when no specific information is available for the selected feat
                    System.out.println("No specific information available for " + selectedFeat);
                }
            }
        });

        featGeneral19ComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFeat = (String) featGeneral19ComboBox.getSelectedItem();
                String featInfo = featInfoMap.get(selectedFeat);
                if (featInfo != null) {
                    featInfoTextArea.setText(featInfo);
                    featInfoPanel.setVisible(true);
                } else {
                    // Handle the case when no specific information is available for the selected feat
                    System.out.println("No specific information available for " + selectedFeat);
                }
            }
        });

        // Action listeners for each skill feat box
        featSkill2ComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFeat = (String) featSkill2ComboBox.getSelectedItem();
                String featInfo = featInfoMap.get(selectedFeat);
                if (featInfo != null) {
                    featInfoTextArea.setText(featInfo);
                    featInfoPanel.setVisible(true);
                } else {
                    // Handle the case when no specific information is available for the selected feat
                    System.out.println("No specific information available for " + selectedFeat);
                }
            }
        });

        featSkill4ComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFeat = (String) featSkill4ComboBox.getSelectedItem();
                String featInfo = featInfoMap.get(selectedFeat);
                if (featInfo != null) {
                    featInfoTextArea.setText(featInfo);
                    featInfoPanel.setVisible(true);
                } else {
                    // Handle the case when no specific information is available for the selected feat
                    System.out.println("No specific information available for " + selectedFeat);
                }
            }
        });

        featSkill6ComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFeat = (String) featSkill6ComboBox.getSelectedItem();
                String featInfo = featInfoMap.get(selectedFeat);
                if (featInfo != null) {
                    featInfoTextArea.setText(featInfo);
                    featInfoPanel.setVisible(true);
                } else {
                    // Handle the case when no specific information is available for the selected feat
                    System.out.println("No specific information available for " + selectedFeat);
                }
            }
        });

        featSkill8ComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFeat = (String) featSkill8ComboBox.getSelectedItem();
                String featInfo = featInfoMap.get(selectedFeat);
                if (featInfo != null) {
                    featInfoTextArea.setText(featInfo);
                    featInfoPanel.setVisible(true);
                } else {
                    // Handle the case when no specific information is available for the selected feat
                    System.out.println("No specific information available for " + selectedFeat);
                }
            }
        });

        featSkill10ComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFeat = (String) featSkill10ComboBox.getSelectedItem();
                String featInfo = featInfoMap.get(selectedFeat);
                if (featInfo != null) {
                    featInfoTextArea.setText(featInfo);
                    featInfoPanel.setVisible(true);
                } else {
                    // Handle the case when no specific information is available for the selected feat
                    System.out.println("No specific information available for " + selectedFeat);
                }
            }
        });

        featSkill12ComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFeat = (String) featSkill12ComboBox.getSelectedItem();
                String featInfo = featInfoMap.get(selectedFeat);
                if (featInfo != null) {
                    featInfoTextArea.setText(featInfo);
                    featInfoPanel.setVisible(true);
                } else {
                    // Handle the case when no specific information is available for the selected feat
                    System.out.println("No specific information available for " + selectedFeat);
                }
            }
        });

        featSkill14ComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFeat = (String) featSkill14ComboBox.getSelectedItem();
                String featInfo = featInfoMap.get(selectedFeat);
                if (featInfo != null) {
                    featInfoTextArea.setText(featInfo);
                    featInfoPanel.setVisible(true);
                } else {
                    // Handle the case when no specific information is available for the selected feat
                    System.out.println("No specific information available for " + selectedFeat);
                }
            }
        });

        featSkill16ComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFeat = (String) featSkill16ComboBox.getSelectedItem();
                String featInfo = featInfoMap.get(selectedFeat);
                if (featInfo != null) {
                    featInfoTextArea.setText(featInfo);
                    featInfoPanel.setVisible(true);
                } else {
                    // Handle the case when no specific information is available for the selected feat
                    System.out.println("No specific information available for " + selectedFeat);
                }
            }
        });

        featSkill18ComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFeat = (String) featSkill18ComboBox.getSelectedItem();
                String featInfo = featInfoMap.get(selectedFeat);
                if (featInfo != null) {
                    featInfoTextArea.setText(featInfo);
                    featInfoPanel.setVisible(true);
                } else {
                    // Handle the case when no specific information is available for the selected feat
                    System.out.println("No specific information available for " + selectedFeat);
                }
            }
        });

        featSkill20ComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFeat = (String) featSkill20ComboBox.getSelectedItem();
                String featInfo = featInfoMap.get(selectedFeat);
                if (featInfo != null) {
                    featInfoTextArea.setText(featInfo);
                    featInfoPanel.setVisible(true);
                } else {
                    // Handle the case when no specific information is available for the selected feat
                    System.out.println("No specific information available for " + selectedFeat);
                }
            }
        });


        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveCharacter();
            }
        });

        openDisplay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initializeDisplay();
            }
        });
    }
    private void updateFeaturesVisibility(int chosenLevel) {
        // Function to update the visibility to the class function displays based on what the selected level of the character is in the creator
        // Written by Ryan Janis
        // April 2024
        // Language: Java

        for (int i = 1; i <= 20; i++) {
            setVisibilityForLevel(i, false);
        }

        // Show features up to the chosen level
        for (int i = 1; i <= chosenLevel; i++) {
            setVisibilityForLevel(i, true);
        }
    }
    private void setVisibilityForLevel(int level, boolean isVisible) {
        // Function to update the visibility of the comboBoxes based on the selected level in the creator
        // Written by Ryan Janis
        // April 2024
        // Language: Java

        switch (level) {
            case 2 -> {
                // Set visibility for level 2 features
                featSkill2ComboBox.setVisible(isVisible);
                featClass2ComboBox.setVisible(isVisible);
            }
            case 3 -> {
                // Set visibility for level 3 features
                classFeaturesLabel3.setVisible(isVisible);
                featGeneral3ComboBox.setVisible(isVisible);
            }
            case 4 -> {
                featSkill4ComboBox.setVisible(isVisible);
                featClass4ComboBox.setVisible(isVisible);
            }
            case 5 -> {
                ancestryFeats5ComboBox.setVisible(isVisible);
                classFeaturesLabel5.setVisible(isVisible);
            }
            case 6 -> {
                featSkill6ComboBox.setVisible(isVisible);
                featClass6ComboBox.setVisible(isVisible);
            }
            case 7 -> {
                classFeaturesLabel7.setVisible(isVisible);
                featGeneral7ComboBox.setVisible(isVisible);
            }
            case 8 -> {
                featSkill8ComboBox.setVisible(isVisible);
                featClass8ComboBox.setVisible(isVisible);
            }
            case 9 -> {
                ancestryFeats9ComboBox.setVisible(isVisible);
                classFeaturesLabel9.setVisible(isVisible);
            }
            case 10 -> {
                featSkill10ComboBox.setVisible(isVisible);
                featClass10ComboBox.setVisible(isVisible);
            }
            case 11 -> {
                classFeaturesLabel11.setVisible(isVisible);
                featGeneral11ComboBox.setVisible(isVisible);
            }
            case 12 -> {
                featSkill12ComboBox.setVisible(isVisible);
                featClass12ComboBox.setVisible(isVisible);
            }
            case 13 -> {
                ancestryFeats13ComboBox.setVisible(isVisible);
                classFeaturesLabel13.setVisible(isVisible);
            }
            case 14 -> {
                featSkill14ComboBox.setVisible(isVisible);
                featClass14ComboBox.setVisible(isVisible);
            }
            case 15 -> {
                classFeaturesLabel15.setVisible(isVisible);
                featGeneral15ComboBox.setVisible(isVisible);
            }
            case 16 -> {
                featSkill16ComboBox.setVisible(isVisible);
                featClass16ComboBox.setVisible(isVisible);
            }
            case 17 -> classFeaturesLabel17.setVisible(isVisible);
            case 18 -> {
                featSkill18ComboBox.setVisible(isVisible);
                featClass18ComboBox.setVisible(isVisible);
            }
            case 19 -> {
                classFeaturesLabel19.setVisible(isVisible);
                featGeneral19ComboBox.setVisible(isVisible);
            }
            case 20 -> {
                featSkill20ComboBox.setVisible(isVisible);
                featClass20ComboBox.setVisible(isVisible);
            }
        }
    }

    private void addComponent(JPanel panel, String labelText, JComponent component) {
        // Function to add a designated component into a panel with a specific layout
        // Written by Ryan Janis
        // February 2024
        // Language: Java

        JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label = new JLabel(labelText);
        rowPanel.add(label);
        rowPanel.add(component);
        panel.add(rowPanel);
    }

    private void addAbilityComponent(JPanel panel, String labelText, JComponent ABox, String modText) {
        // Function to add the ability score and modifier components to the program and calculate the ability modifier in real time
        // Written by Ryan Janis
        // April 2024
        // Language: Java

        final int[] modifier = {0};

        JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label = new JLabel(labelText);
        JLabel modLabel = new JLabel(modText);
        JLabel modifierLabel = new JLabel("+" + String.valueOf(modifier[0]));

            JTextComponent textField = (JTextComponent) ABox;
            textField.getDocument().addDocumentListener(new DocumentListener() {

                @Override
                public void insertUpdate(DocumentEvent e) {
                    String text = textField.getText();
                    if (!text.isEmpty()) {
                        int newValue = Integer.parseInt(textField.getText());
                        newValue = (newValue - 10) / 2;
                        modifier[0] = newValue;
                        if (newValue >= 0) {
                            modifierLabel.setText("+" + (modifier[0]));
                        } else {
                            modifierLabel.setText(String.valueOf(modifier[0]));
                        }
                    }
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    String text = textField.getText();
                    if (!text.isEmpty()) {
                        int newValue = Integer.parseInt(textField.getText());
                        newValue = (newValue - 10) / 2;
                        modifier[0] = newValue;
                        if (newValue >= 0) {
                            modifierLabel.setText("+" + (modifier[0]));
                        } else {
                            modifierLabel.setText(String.valueOf(modifier[0]));
                        }
                    }
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    String text = textField.getText();
                    if (!text.isEmpty()) {
                        int newValue = Integer.parseInt(textField.getText());
                        newValue = (newValue - 10) / 2;
                        modifier[0] = newValue;
                        if (newValue >= 0) {
                            modifierLabel.setText("+" + (modifier[0]));
                        } else {
                            modifierLabel.setText(String.valueOf(modifier[0]));
                        }
                    }
                }
            });

            rowPanel.add(label);
            rowPanel.add(ABox);
            rowPanel.add(modLabel);
            rowPanel.add(modifierLabel);
            panel.add(rowPanel);

    }

    private void addLabel(JPanel panel, JComponent component) {
        // Function to add a label to the panel
        // Written by Ryan Janis
        // March 2024
        // Language: Java

        JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        rowPanel.add(component);
        panel.add(rowPanel);
    }
    private void addSkill(JPanel panel, String labelText, int[] skillLevel) {
        // Function to add the skills to the panel with radioButtons for level
        // Written by Ryan Janis
        // April 2024
        // Language: Java

        JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label = new JLabel(labelText);
        JRadioButton trainRadioButton = new JRadioButton("Trained");
        JRadioButton expertRadioButton = new JRadioButton("Expert");
        JRadioButton masterRadioButton = new JRadioButton("Master");
        JRadioButton legendRadioButton = new JRadioButton("Legendary");

        ButtonGroup levelButtonGroup = new ButtonGroup();
        levelButtonGroup.add(trainRadioButton);
        levelButtonGroup.add(expertRadioButton);
        levelButtonGroup.add(masterRadioButton);
        levelButtonGroup.add(legendRadioButton);

        switch (skillLevel[0]) {
            case 1:
                trainRadioButton.setSelected(true);
                break;
            case 2:
                expertRadioButton.setSelected(true);
                break;
            case 3:
                masterRadioButton.setSelected(true);
                break;
            case 4:
                legendRadioButton.setSelected(true);
                break;
            default:
                break;
        }

        // Add action listeners to the level radio buttons
        trainRadioButton.addActionListener(e -> {
            if (trainRadioButton.isSelected()) {
                // Update the external value for skill 1 to level 1
                skillLevel[0] = 1;
            }
        });
        expertRadioButton.addActionListener(e -> {
            if (expertRadioButton.isSelected()) {
                // Update the external value for skill 1 to level 2
                skillLevel[0] = 2;
            }
        });
        masterRadioButton.addActionListener(e -> {
            if (masterRadioButton.isSelected()) {
                // Update the external value for skill 1 to level 2
                skillLevel[0] = 3;
            }
        });
        legendRadioButton.addActionListener(e -> {
            if (legendRadioButton.isSelected()) {
                // Update the external value for skill 1 to level 2
                skillLevel[0] = 4;
            }
        });

        rowPanel.add(label);
        rowPanel.add(trainRadioButton);
        rowPanel.add(expertRadioButton);
        rowPanel.add(masterRadioButton);
        rowPanel.add(legendRadioButton);
        panel.add(rowPanel);
    }
    private int returnInt(JTextField field) {
        // Function to return the integer value of a given number in the passed textField
        // Written by Ryan Janis
        // April 2024
        // Language: Java

        int abilityScore;
        String number = field.getText();

        abilityScore = Integer.parseInt(number);

        return abilityScore;
    }

    private String displayFeatures(int arrayIndex, int classIndex) {
        // Function to display the class features of the selected class on the panel using html formatting
        // Written by Ryan Janis
        // March 2024
        // Language: Java

        String[][][] arrayOfFeatureArrays = {classFeatures1, classFeatures3, classFeatures5, classFeatures7, classFeatures9, classFeatures11, classFeatures13, classFeatures15, classFeatures17, classFeatures19};
        String[] extractedElements = extractRow(arrayOfFeatureArrays, arrayIndex, classIndex);

        String featureText = "<html><body style='width: 270px'>";

        for(String element : extractedElements){
            featureText = featureText + element + ": " + featInfoMap.get(element) + "<br />";
        }
        featureText = featureText + "</body></html>";

        return featureText;
    }

    public String[] extractRow(String[][][] arrayOfArrays, int arrayIndex, int classIndex) {
        // Function to extract a specific row from an array to use later
        // Written by Ryan Janis
        // March 2024
        // Language: Java

        // Get the size of the original array to determine the size of new array
        int numColumns = arrayOfArrays[arrayIndex][classIndex - 1].length;

        // Create an array to store the extracted elements
        String[] extractedElements = new String[numColumns];

        // Iterate through the specified row and extract elements into the array
        for (int i = 0; i < numColumns; i++) {
            extractedElements[i] = arrayOfArrays[arrayIndex][classIndex - 1][i];
        }

        return extractedElements;
    }

    private void initializeDisplay() {
       // Function to initilize the display window and all of its contents
       // Written by Ryan Janis
       // April 2024, Modified May 2024
       // Language: Java

        String dClass = "";
        int dLevel = 0;
        String dAncestry = "";
        String dSTR = "";
        String dDEX = "";
        String dCON = "";
        String dINT = "";
        String dWIS = "";
        String dCHA = "";
        int pBonus;
        int speed = 0;
        int classDC = 0;
        int HP = 0;
        int classHP = 0;
        int ancestryHP = 0;
        int perception;
        int keyAbility = 0;
        int attackMod = 0;
        int ACBonus;
        int reflex = 0;
        int will = 0;
        int fortitude = 0;
        String damage1 = "";
        String damage2 = "";
        String damage3 = "";
        String mainWeapon = "";
        String secondaryWeapon = "";
        String tirtiaryWeapon = "";
        String dAcrobatics = "";
        String dArcana = "";
        String dAthletics = "";
        String dCrafting = "";
        String dDeception = "";
        String dDiplomacy = "";
        String dIntimidation = "";
        String dMedicine = "";
        String dNature = "";
        String dOccultism = "";
        String dPerformance = "";
        String dReligion = "";
        String dStealth = "";
        String dSociety = "";
        String dSurvival = "";
        String dThievery = "";

        JFileChooser displayChooser = new JFileChooser(new File("characters"));
        int dResult = displayChooser.showOpenDialog(this);
        if (dResult == JFileChooser.APPROVE_OPTION) {
            File selectedFile = displayChooser.getSelectedFile();
            Map<String, String> characterDetails = loadCharacterFromFile(selectedFile);
            if (characterDetails != null) {
                dClass = characterDetails.get("Class");
                dLevel = Integer.parseInt(characterDetails.get("Level"));
                dAncestry = characterDetails.get("Ancestry");
                dSTR = characterDetails.get("Strength");
                dDEX = characterDetails.get("Dexterity");
                dCON = characterDetails.get("Constitution");
                dINT = characterDetails.get("Intelligence");
                dWIS = characterDetails.get("Wisdom");
                dCHA = characterDetails.get("Charisma");
                dAcrobatics = characterDetails.get("Acrobatics");
                dArcana = characterDetails.get("Arcana");
                dAthletics = characterDetails.get("Athletics");
                dCrafting = characterDetails.get("Crafting");
                dDeception = characterDetails.get("Deception");
                dDiplomacy = characterDetails.get("Diplomacy");
                dIntimidation = characterDetails.get("Intimidation");
                dMedicine = characterDetails.get("Medicine");
                dNature = characterDetails.get("Nature");
                dOccultism = characterDetails.get("Occultism");
                dPerformance = characterDetails.get("Performance");
                dReligion = characterDetails.get("Religion");
                dStealth = characterDetails.get("Stealth");
                dSociety = characterDetails.get("Society");
                dSurvival = characterDetails.get("Survival");
                dThievery = characterDetails.get("Thievery");

            } else {
                System.out.println("Error loading character: Invalid file format or file not found.");
            }
        }

        // Proficiency Bonus calculation
        pBonus = dLevel + 2;

        // Class Based Calculations
        switch (dClass) {
            case "Barbarian" -> {
                classHP = 12;
                keyAbility = Integer.parseInt(dSTR);
                mainWeapon = "Great Axe";
                attackMod = (keyAbility - 10)/2 + pBonus;
                damage1 = "1d12 + ";
                secondaryWeapon = "Silvered Longsword";
                damage2 = "1d10 + ";
                tirtiaryWeapon = "Club";
                damage3 = "1d4 + ";
                reflex = (Integer.parseInt(dDEX) - 10)/2 + pBonus;
                will = (Integer.parseInt(dWIS) - 10)/2 + pBonus + 2;
                fortitude = (Integer.parseInt(dCON) - 10)/2 + pBonus + 2;
            }
            case "Bard" -> {
                classHP = 8;
                keyAbility = Integer.parseInt(dCHA);
                mainWeapon = "Vicious Mockery";
                attackMod = (keyAbility - 10)/2 + pBonus;
                damage1 = "1d4 + ";
                secondaryWeapon = "Dagger";
                damage2 = "1d4 + ";
                tirtiaryWeapon = "Quarterstaff";
                damage3 = "1d4";
                reflex = (Integer.parseInt(dDEX) - 10)/2 + pBonus;
                will = (Integer.parseInt(dWIS) - 10)/2 + pBonus + 2;
                fortitude = (Integer.parseInt(dCON) - 10)/2 + pBonus;
            }
            case "Champion" -> {
                classHP = 10;
                keyAbility = Integer.parseInt(dCHA);
                mainWeapon = "Longsword";
                attackMod = (keyAbility - 10)/2 + pBonus;
                damage1 = "1d10 + ";
                secondaryWeapon = "Maul";
                damage2 = "1d10 + ";
                tirtiaryWeapon = "Light Hammer";
                damage3 = "1d4 + ";
                reflex = (Integer.parseInt(dDEX) - 10)/2 + pBonus;
                will = (Integer.parseInt(dWIS) - 10)/2 + pBonus + 2;
                fortitude = (Integer.parseInt(dCON) - 10)/2 + pBonus + 2;
            }
            case "Cleric" -> {
                classHP = 8;
                keyAbility = Integer.parseInt(dWIS);
                mainWeapon = "Mace";
                attackMod = (keyAbility - 10)/2 + pBonus;
                damage1 = "1d8 + ";
                secondaryWeapon = "Divine Smite";
                damage2 = "1d8/Spell Level + ";
                tirtiaryWeapon = "Toll The Dead";
                damage3 = "1d8 or 1d12 + ";
                reflex = (Integer.parseInt(dDEX) - 10)/2 + pBonus;
                will = (Integer.parseInt(dWIS) - 10)/2 + pBonus + 2;
                fortitude = (Integer.parseInt(dCON) - 10)/2 + pBonus;
            }
            case "Druid" -> {
                classHP = 8;
                keyAbility = Integer.parseInt(dWIS);
                mainWeapon = "Thorn Whip";
                attackMod = (keyAbility - 10)/2 + pBonus;
                damage1 = "1d6 + ";
                secondaryWeapon = "Dagger";
                damage2 = "1d4 + ";
                tirtiaryWeapon = "Club";
                damage3 = "1d4 + ";
                reflex = (Integer.parseInt(dDEX) - 10)/2 + pBonus;
                will = (Integer.parseInt(dWIS) - 10)/2 + pBonus + 2;
                fortitude = (Integer.parseInt(dCON) - 10)/2 + pBonus;
            }
            case "Fighter" -> {
                classHP = 10;
                keyAbility = Integer.parseInt(dSTR);
                mainWeapon = "Great Sword";
                attackMod = (keyAbility - 10)/2 + pBonus;
                damage1 = "2d6 + ";
                secondaryWeapon = "Longsword";
                damage2 = "1d10 + ";
                tirtiaryWeapon = "Longbow";
                damage3 = "1d8 + ";
                reflex = (Integer.parseInt(dDEX) - 10)/2 + pBonus + 2;
                will = (Integer.parseInt(dWIS) - 10)/2 + pBonus;
                fortitude = (Integer.parseInt(dCON) - 10)/2 + pBonus + 2;
            }
            case "Monk" -> {
                classHP = 8;
                keyAbility = Integer.parseInt(dDEX);
                mainWeapon = "Unarmed Strike";
                attackMod = (keyAbility - 10)/2 + pBonus;
                damage1 = "1d8 + ";
                secondaryWeapon = "Dart";
                damage2 = "1d4 + ";
                tirtiaryWeapon = "Staff";
                damage3 = "1d6 + ";
                reflex = (Integer.parseInt(dDEX) - 10)/2 + pBonus + 2;
                will = (Integer.parseInt(dWIS) - 10)/2 + pBonus + 2;
                fortitude = (Integer.parseInt(dCON) - 10)/2 + pBonus + 2;
            }
            case "Ranger" -> {
                classHP = 10;
                keyAbility = Integer.parseInt(dDEX);
                mainWeapon = "Longbow";
                attackMod = (keyAbility - 10)/2 + pBonus;
                damage1 = "1d8 + ";
                secondaryWeapon = "Shortsword";
                damage2 = "1d6 + ";
                tirtiaryWeapon = "Dagger";
                damage3 = "1d4 + ";
                reflex = (Integer.parseInt(dDEX) - 10)/2 + pBonus + 2;
                will = (Integer.parseInt(dWIS) - 10)/2 + pBonus;
                fortitude = (Integer.parseInt(dCON) - 10)/2 + pBonus + 2;
            }
            case "Rogue" -> {
                classHP = 8;
                keyAbility = Integer.parseInt(dDEX);
                mainWeapon = "Dagger";
                attackMod = (keyAbility - 10)/2 + pBonus;
                damage1 = "1d4 + ";
                secondaryWeapon = "Poisoned Dagger";
                damage2 = "2d4 + ";
                tirtiaryWeapon = "Shortsword";
                damage3 = "1d6 + ";
                reflex = (Integer.parseInt(dDEX) - 10)/2 + pBonus + 2;
                will = (Integer.parseInt(dWIS) - 10)/2 + pBonus + 2;
                fortitude = (Integer.parseInt(dCON) - 10)/2 + pBonus;
            }
            case "Sorcerer" -> {
                classHP = 6;
                keyAbility = Integer.parseInt(dCHA);
                mainWeapon = "Fire Bolt";
                attackMod = (keyAbility - 10)/2 + pBonus;
                damage1 = "1d10 + ";
                secondaryWeapon = "Ray of Frost";
                damage2 = "1d8 + ";
                tirtiaryWeapon = "Electric Arc";
                damage3 = "1d4 + ";
                reflex = (Integer.parseInt(dDEX) - 10)/2 + pBonus;
                will = (Integer.parseInt(dWIS) - 10)/2 + pBonus + 2;
                fortitude = (Integer.parseInt(dCON) - 10)/2 + pBonus;
            }
            case "Wizard" -> {
                classHP = 6;
                keyAbility = Integer.parseInt(dINT);
                mainWeapon = "Magic Missile";
                attackMod = (keyAbility - 10)/2 + pBonus;
                damage1 = "4d4 + ";
                secondaryWeapon = "Caustic Blast";
                damage2 = "1d8 + ";
                tirtiaryWeapon = "Electric Arc";
                damage3 = "1d4 + ";
                reflex = (Integer.parseInt(dDEX) - 10)/2 + pBonus;
                will = (Integer.parseInt(dWIS) - 10)/2 + pBonus + 2;
                fortitude = (Integer.parseInt(dCON) - 10)/2 + pBonus;
            }
        }

        // Ancestry Based Calculations
        switch (dAncestry) {
            case "Dwarf" -> {
                ancestryHP = 10;
                speed = 20;
            }
            case "Elf" -> {
                ancestryHP = 6;
                speed = 30;
            }
            case "Gnome", "Human" -> {
                ancestryHP = 8;
                speed = 25;
            }
            case "Halfling" -> {
                ancestryHP = 6;
                speed = 25;
            }
        }




        // Health calculation
        HP = (classHP + (Integer.parseInt(dCON) - 10)/2) * dLevel + ancestryHP;

        // Perception Calculation
        perception = (Integer.parseInt(dWIS) - 10)/2 + pBonus;

        // Calculate Class DC
        classDC = 10 + (keyAbility - 10)/2 + pBonus;



        // Ability Modifier calculations
        dSTR = String.valueOf((Integer.parseInt(dSTR) - 10)/2);
        if (Integer.parseInt(dSTR) >= 0) {
            dSTR = "+" + dSTR;
        }
        dDEX = String.valueOf((Integer.parseInt(dDEX) - 10)/2);
        ACBonus = Integer.parseInt(dDEX);
        if (Integer.parseInt(dDEX) >= 0) {
            dDEX = "+" + dDEX;
        }
        dCON = String.valueOf((Integer.parseInt(dCON) - 10)/2);
        if (Integer.parseInt(dCON) >= 0) {
            dCON = "+" + dCON;
        }
        dINT = String.valueOf((Integer.parseInt(dINT) - 10)/2);
        if (Integer.parseInt(dINT) >= 0) {
            dINT = "+" + dINT;
        }
        dWIS = String.valueOf((Integer.parseInt(dWIS) - 10)/2);
        if (Integer.parseInt(dWIS) >= 0) {
            dWIS = "+" + dWIS;
        }
        dCHA = String.valueOf((Integer.parseInt(dCHA) - 10)/2);
        if (Integer.parseInt(dCHA) >= 0) {
            dCHA = "+" + dCHA;
        }


        // Skill Calculations
        if (Integer.parseInt(dAcrobatics) > 0) {
            dAcrobatics = String.valueOf((Integer.parseInt(dAcrobatics) - 1) * 2 + pBonus);
            dAcrobatics = "+" + dAcrobatics;
        } else {
            dAcrobatics = dDEX;
        }
        if (Integer.parseInt(dArcana) > 0) {
            dArcana = String.valueOf((Integer.parseInt(dArcana) - 1) * 2 + pBonus);
            dArcana = "+" + dArcana;
        } else {
            dArcana = dINT;
        }
        if (Integer.parseInt(dAthletics) > 0) {
            dAthletics = String.valueOf((Integer.parseInt(dAthletics) - 1) * 2 + pBonus);
            dAthletics = "+" + dAthletics;
        } else {
            dAthletics = dSTR;
        }
        if (Integer.parseInt(dCrafting) > 0) {
            dCrafting = String.valueOf((Integer.parseInt(dCrafting) - 1) * 2 + pBonus);
            dCrafting = "+" + dCrafting;
        } else {
            dCrafting = dINT;
        }
        if (Integer.parseInt(dDeception) > 0) {
            dDeception = String.valueOf((Integer.parseInt(dDeception) - 1) * 2 + pBonus);
            dDeception = "+" + dDeception;
        } else {
            dDeception = dCHA;
        }
        if (Integer.parseInt(dDiplomacy) > 0) {
            dDiplomacy = String.valueOf((Integer.parseInt(dDiplomacy) - 1) * 2 + pBonus);
            dDiplomacy = "+" + dDiplomacy;
        } else {
            dDiplomacy = dCHA;
        }
        if (Integer.parseInt(dIntimidation) > 0) {
            dIntimidation = String.valueOf((Integer.parseInt(dIntimidation) - 1) * 2 + pBonus);
            dIntimidation = "+" + dIntimidation;
        } else {
            dIntimidation = dCHA;
        }
        if (Integer.parseInt(dMedicine) > 0) {
            dMedicine = String.valueOf((Integer.parseInt(dMedicine) - 1) * 2 + pBonus);
            dMedicine = "+" + dMedicine;
        } else {
            dMedicine = dWIS;
        }
        if (Integer.parseInt(dNature) > 0) {
            dNature = String.valueOf((Integer.parseInt(dNature) - 1) * 2 + pBonus);
            dNature = "+" + dNature;
        } else {
            dNature = dWIS;
        }
        if (Integer.parseInt(dOccultism) > 0) {
            dOccultism = String.valueOf((Integer.parseInt(dOccultism) - 1) * 2 + pBonus);
            dOccultism = "+" + dOccultism;
        } else {
            dOccultism = dINT;
        }
        if (Integer.parseInt(dPerformance) > 0) {
            dPerformance = String.valueOf((Integer.parseInt(dPerformance) - 1) * 2 + pBonus);
            dPerformance = "+" + dPerformance;
        } else {
            dPerformance = dCHA;
        }
        if (Integer.parseInt(dReligion) > 0) {
            dReligion = String.valueOf((Integer.parseInt(dReligion) - 1) * 2 + pBonus);
            dReligion = "+" + dReligion;
        } else {
            dReligion = dWIS;
        }
        if (Integer.parseInt(dStealth) > 0) {
            dStealth = String.valueOf((Integer.parseInt(dStealth) - 1) * 2 + pBonus);
            dStealth = "+" + dStealth;
        } else {
            dStealth = dDEX;
        }
        if (Integer.parseInt(dSociety) > 0) {
            dSociety = String.valueOf((Integer.parseInt(dSociety) - 1) * 2 + pBonus);
            dSociety = "+" + dSociety;
        } else {
            dSociety = dINT;
        }
        if (Integer.parseInt(dSurvival) > 0) {
            dSurvival = String.valueOf((Integer.parseInt(dSurvival) - 1) * 2 + pBonus);
            dSurvival = "+" + dSurvival;
        } else {
            dSurvival = dWIS;
        }
        if (Integer.parseInt(dThievery) > 0) {
            dThievery = String.valueOf((Integer.parseInt(dThievery) - 1) * 2 + pBonus);
            dThievery = "+" + dThievery;
        } else {
            dThievery = dDEX;
        }




        JFrame displayFrame = new JFrame();
        displayFrame.setTitle("Pathfinder Character Display");
        displayFrame.setSize(340, 400);
        displayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        displayFrame.setLayout(new BorderLayout());
        // Center the new window on the screen
        displayFrame.setLocationRelativeTo(null);

        // Make the new window visible
        displayFrame.setVisible(true);

        // Make Panel for stats (North)
        JPanel abilityPanel = new JPanel(new GridLayout(2, 6));
        abilityPanel.setBorder(BorderFactory.createEmptyBorder(0,5,0,0));
        abilityPanel.setVisible(true);
            abilityPanel.add(new JLabel("STR: "));
            abilityPanel.add(new JLabel("DEX: "));
            abilityPanel.add(new JLabel("CON: "));
            abilityPanel.add(new JLabel("INT: "));
            abilityPanel.add(new JLabel("WIS: "));
            abilityPanel.add(new JLabel("CHA: "));
            abilityPanel.add(new JLabel(dSTR));
            abilityPanel.add(new JLabel(dDEX));
            abilityPanel.add(new JLabel(dCON));
            abilityPanel.add(new JLabel(dINT));
            abilityPanel.add(new JLabel(dWIS));
            abilityPanel.add(new JLabel(dCHA));

        abilityPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        displayFrame.add(abilityPanel, BorderLayout.NORTH);

        // Make Panel for HP, AC, and Attacks (West)
        JPanel westPanel = new JPanel(new BorderLayout());
        westPanel.setVisible(true);
            // rowPanel for HP
            JPanel healthPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                healthPanel.add(new JLabel("HP:"));
                healthPanel.add(healthField = new JTextField(3));
                healthPanel.add(new JLabel("/" + String.valueOf(HP)));
                healthField.setText(String.valueOf(HP));
                healthPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            // rowPanel for AC
            JPanel ACPanel = new JPanel(new GridLayout(4,0));
                ACBonus = 10 + ACBonus + pBonus;
                ACPanel.add(new JLabel(" Armor Class: " + ACBonus));
                ACPanel.add(new JLabel(" Reflex Save: +" + reflex));
                ACPanel.add(new JLabel(" Will Save: +" + will));
                ACPanel.add(new JLabel(" Fortitude Save: +" + fortitude));
                ACPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            // Some sort of panel that will probably be full of row panels for attacks
            JPanel combatPanel = new JPanel(new GridLayout(4,0));
                combatPanel.add(new JLabel(" Attack Actions:"));
            JPanel attack1Panel = new JPanel(new GridLayout(2,0));
                attack1Panel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
                attack1Panel.add(new JLabel(mainWeapon +": +" + attackMod));
                attack1Panel.add(new JLabel("Damage: " + damage1 + (keyAbility - 10)/2));
            JPanel attack2Panel = new JPanel(new GridLayout(2,0));
                attack2Panel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
                attack2Panel.add(new JLabel(secondaryWeapon +": +" + attackMod));
                attack2Panel.add(new JLabel("Damage: " + damage2 + (keyAbility - 10)/2));
            JPanel attack3Panel = new JPanel(new GridLayout(2,0));
                attack3Panel.setBorder(BorderFactory.createEmptyBorder(5,5,5,0));
                attack3Panel.add(new JLabel(tirtiaryWeapon +": +" + attackMod));
                attack3Panel.add(new JLabel("Damage: " + damage3 + (keyAbility - 10)/2));
            combatPanel.add(attack1Panel);
            combatPanel.add(attack2Panel);
            combatPanel.add(attack3Panel);
            combatPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        westPanel.add(healthPanel, BorderLayout.NORTH);
        westPanel.add(ACPanel, BorderLayout.CENTER);
        westPanel.add(combatPanel, BorderLayout.SOUTH);
        westPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Make Panel for Class DC, Speed, and Skills
        JPanel eastPanel = new JPanel(new BorderLayout());
        eastPanel.setVisible(true);
            // rowPanel for Perception
            JPanel perceptionPanel = new JPanel();
            perceptionPanel.add(new JLabel("Perception: +" + perception));
            perceptionPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            // two panels inside a rowPanel probably for class DC, and speed.
            JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                rowPanel.add(new JLabel("Class DC: " + classDC));
                rowPanel.add(new JLabel("Speed: " + speed));
                rowPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            // Grid panel with a bunch of labels for skills.
            JPanel skillPanel = new JPanel(new GridLayout(16, 2));
                skillPanel.add(new JLabel(" Acrobatics: "));
                skillPanel.add(new JLabel(dAcrobatics));
                skillPanel.add(new JLabel(" Arcana: "));
                skillPanel.add(new JLabel(dArcana));
                skillPanel.add(new JLabel(" Athletics: "));
                skillPanel.add(new JLabel(dAthletics));
                skillPanel.add(new JLabel(" Crafting: "));
                skillPanel.add(new JLabel(dCrafting));
                skillPanel.add(new JLabel(" Deception: "));
                skillPanel.add(new JLabel(dDeception));
                skillPanel.add(new JLabel(" Diplomacy: "));
                skillPanel.add(new JLabel(dDiplomacy));
                skillPanel.add(new JLabel(" Intimidation: "));
                skillPanel.add(new JLabel(dIntimidation));
                skillPanel.add(new JLabel(" Medicine: "));
                skillPanel.add(new JLabel(dMedicine));
                skillPanel.add(new JLabel(" Nature: "));
                skillPanel.add(new JLabel(dNature));
                skillPanel.add(new JLabel(" Occultism: "));
                skillPanel.add(new JLabel(dOccultism));
                skillPanel.add(new JLabel(" Performance: "));
                skillPanel.add(new JLabel(dPerformance));
                skillPanel.add(new JLabel(" Religion: "));
                skillPanel.add(new JLabel(dReligion));
                skillPanel.add(new JLabel(" Society: "));
                skillPanel.add(new JLabel(dSociety));
                skillPanel.add(new JLabel(" Stealth: "));
                skillPanel.add(new JLabel(dStealth));
                skillPanel.add(new JLabel(" Survival: "));
                skillPanel.add(new JLabel(dSurvival));
                skillPanel.add(new JLabel(" Thievery: "));
                skillPanel.add(new JLabel(dThievery));
                skillPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        eastPanel.add(perceptionPanel, BorderLayout.NORTH);
        eastPanel.add(rowPanel, BorderLayout.CENTER);
        eastPanel.add(skillPanel, BorderLayout.SOUTH);
        eastPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    displayFrame.add(westPanel, BorderLayout.WEST);
    displayFrame.add(eastPanel, BorderLayout.EAST);
    }
    private void saveCharacter() {
        // Function to save all the selected and entered information from the character sheet to a separate file in the characters folder
        // Written by Ryan Janis
        // March 2024, Modified April 2024
        //Language: Java

        // Get the information
        String characterName = characterNameField.getText();
        String selectedAncestry = (String) ancestryComboBox.getSelectedItem();
        String selectedHeritage = (String) heritageComboBox.getSelectedItem();
        String selectedBackground = (String) backgroundComboBox.getSelectedItem();
        int selectedLevel = (Integer) levelComboBox.getSelectedItem();
        String selectedClass = (String) classComboBox.getSelectedItem();
        int strength = returnInt(strField);
        int dexterity = returnInt(dexField);
        int constitution = returnInt(conField);
        int intelligence = returnInt(intField);
        int wisdom = returnInt(wisField);
        int charisma = returnInt(chaField);
        String selectedAncestryFeat1 = (String) ancestryFeats1ComboBox.getSelectedItem();
        String selectedClassFeat1 = (String) featClass1ComboBox.getSelectedItem();
        String selectedSkillFeat2 = (String) featSkill2ComboBox.getSelectedItem();
        String selectedClassFeat2 = (String) featClass2ComboBox.getSelectedItem();
        String selectedGeneralFeat3 = (String) featGeneral3ComboBox.getSelectedItem();
        String selectedSkillFeat4 = (String) featSkill4ComboBox.getSelectedItem();
        String selectedClassFeat4 = (String) featClass4ComboBox.getSelectedItem();
        String selectedAncestryFeat5 = (String) ancestryFeats5ComboBox.getSelectedItem();
        String selectedSkillFeat6 = (String) featSkill6ComboBox.getSelectedItem();
        String selectedClassFeat6 = (String) featClass6ComboBox.getSelectedItem();
        String selectedGeneralFeat7 = (String) featGeneral7ComboBox.getSelectedItem();
        String selectedSkillFeat8 = (String) featSkill8ComboBox.getSelectedItem();
        String selectedClassFeat8 = (String) featClass8ComboBox.getSelectedItem();
        String selectedAncestryFeat9 = (String) ancestryFeats9ComboBox.getSelectedItem();
        String selectedSkillFeat10 = (String) featSkill10ComboBox.getSelectedItem();
        String selectedClassFeat10 = (String) featClass10ComboBox.getSelectedItem();
        String selectedGeneralFeat11 = (String) featGeneral11ComboBox.getSelectedItem();
        String selectedSkillFeat12 = (String) featSkill12ComboBox.getSelectedItem();
        String selectedClassFeat12 = (String) featClass12ComboBox.getSelectedItem();
        String selectedAncestryFeat13 = (String) ancestryFeats13ComboBox.getSelectedItem();
        String selectedSkillFeat14 = (String) featSkill14ComboBox.getSelectedItem();
        String selectedClassFeat14 = (String) featClass14ComboBox.getSelectedItem();
        String selectedGeneralFeat15 = (String) featGeneral15ComboBox.getSelectedItem();
        String selectedSkillFeat16 = (String) featSkill16ComboBox.getSelectedItem();
        String selectedClassFeat16 = (String) featClass16ComboBox.getSelectedItem();
        String selectedSkillFeat18 = (String) featSkill14ComboBox.getSelectedItem();
        String selectedClassFeat18 = (String) featClass14ComboBox.getSelectedItem();
        String selectedGeneralFeat19 = (String) featGeneral19ComboBox.getSelectedItem();
        String selectedSkillFeat20 = (String) featSkill20ComboBox.getSelectedItem();
        String selectedClassFeat20 = (String) featClass20ComboBox.getSelectedItem();


        // Save the details to a text file
        try (PrintWriter writer = new PrintWriter(new FileWriter("characters/" + characterName + ".txt"))) {
            writer.println("Character Name: " + characterName);
            writer.println("Ancestry: " + selectedAncestry);
            writer.println("Heritage: " + selectedHeritage);
            writer.println("Background: " + selectedBackground);
            writer.println("Level: " + selectedLevel);
            writer.println("Class: " + selectedClass);
            writer.println(("Strength: " + strength));
            writer.println(("Dexterity: " + dexterity));
            writer.println(("Constitution: " + constitution));
            writer.println(("Intelligence: " + intelligence));
            writer.println(("Wisdom: " + wisdom));
            writer.println(("Charisma: " + charisma));
            writer.println(("Acrobatics: " + acrobatics[0]));
            writer.println(("Arcana: " + arcana[0]));
            writer.println(("Athletics: " + athletics[0]));
            writer.println(("Crafting: " + crafting[0]));
            writer.println(("Deception: " + deception[0]));
            writer.println(("Diplomacy: " + diplomacy[0]));
            writer.println(("Intimidation: " + intimidation[0]));
            writer.println(("Medicine: " + medicine[0]));
            writer.println(("Nature: " + nature[0]));
            writer.println(("Occultism: " + occultism[0]));
            writer.println(("Performance: " + performance[0]));
            writer.println(("Religion: " + religion[0]));
            writer.println(("Society: " + society[0]));
            writer.println(("Stealth: " + stealth[0]));
            writer.println(("Survival: " + survival[0]));
            writer.println(("Thievery: " + thievery[0]));
            writer.println("Ancestry Feat 1: " + selectedAncestryFeat1);
            writer.println("Class Feat 1: " + selectedClassFeat1);
            writer.println("Class Feat 2: " + selectedClassFeat2);
            writer.println("Skill Feat 2: " + selectedSkillFeat2);
            writer.println("General Feat 3: " + selectedGeneralFeat3);
            writer.println("Class Feat 4: " + selectedClassFeat4);
            writer.println("Skill Feat 4: " + selectedSkillFeat4);
            writer.println("Ancestry Feat 5: " + selectedAncestryFeat5);
            writer.println("Class Feat 6: " + selectedClassFeat6);
            writer.println("Skill Feat 6: " + selectedSkillFeat6);
            writer.println("General Feat 7: " + selectedGeneralFeat7);
            writer.println("Class Feat 8: " + selectedClassFeat8);
            writer.println("Skill Feat 8: " + selectedSkillFeat8);
            writer.println("Ancestry Feat 9: " + selectedAncestryFeat9);
            writer.println("Class Feat 10: " + selectedClassFeat10);
            writer.println("Skill Feat 10: " + selectedSkillFeat10);
            writer.println("General Feat 11: " + selectedGeneralFeat11);
            writer.println("Class Feat 12: " + selectedClassFeat12);
            writer.println("Skill Feat 12: " + selectedSkillFeat12);
            writer.println("Ancestry Feat 13: " + selectedAncestryFeat13);
            writer.println("Class Feat 14: " + selectedClassFeat14);
            writer.println("Skill Feat 14: " + selectedSkillFeat14);
            writer.println("General Feat 15: " + selectedGeneralFeat15);
            writer.println("Class Feat 16: " + selectedClassFeat16);
            writer.println("Skill Feat 16: " + selectedSkillFeat16);
            writer.println("Class Feat 18: " + selectedClassFeat18);
            writer.println("Skill Feat 18: " + selectedSkillFeat18);
            writer.println("General Feat 19: " + selectedGeneralFeat19);
            writer.println("Class Feat 20: " + selectedClassFeat20);
            writer.println("Skill Feat 20: " + selectedSkillFeat20);

            JOptionPane.showMessageDialog(this, "Character saved successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving character: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
    private void loadCharacter() {
        // Function to load in the saved information for the character
        // Written by Ryan Janis
        // March 2024, Modified April 2024
        // Language: Java

        JFileChooser fileChooser = new JFileChooser(new File("characters"));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            Map<String, String> characterDetails = loadCharacterFromFile(selectedFile);
            if (characterDetails != null) {
                acrobatics[0] = Integer.parseInt(characterDetails.get("Acrobatics"));
                arcana[0] = Integer.parseInt(characterDetails.get("Arcana"));
                athletics[0] = Integer.parseInt(characterDetails.get("Athletics"));
                crafting[0] = Integer.parseInt(characterDetails.get("Crafting"));
                deception[0] = Integer.parseInt(characterDetails.get("Deception"));
                diplomacy[0] = Integer.parseInt(characterDetails.get("Diplomacy"));
                intimidation[0] = Integer.parseInt(characterDetails.get("Intimidation"));
                medicine[0] = Integer.parseInt(characterDetails.get("Medicine"));
                nature[0] = Integer.parseInt(characterDetails.get("Nature"));
                occultism[0] = Integer.parseInt(characterDetails.get("Occultism"));
                performance[0] = Integer.parseInt(characterDetails.get("Performance"));
                religion[0] = Integer.parseInt(characterDetails.get("Religion"));
                stealth[0] = Integer.parseInt(characterDetails.get("Stealth"));
                society[0] = Integer.parseInt(characterDetails.get("Society"));
                survival[0] = Integer.parseInt(characterDetails.get("Survival"));
                thievery[0] = Integer.parseInt(characterDetails.get("Thievery"));

                // After the skill initialization we can initialize the program
                if (characterNameField == null) {
                    initializeComponents();
                }

                // Set loaded character details into combo boxes
                characterNameField.setText(characterDetails.get("Character Name"));
                ancestryComboBox.setSelectedItem(characterDetails.get("Ancestry"));
                heritageComboBox.setSelectedItem(characterDetails.get("Heritage"));
                levelComboBox.setSelectedItem(Integer.parseInt(characterDetails.get("Level")));
                backgroundComboBox.setSelectedItem(characterDetails.get("Background"));
                classComboBox.setSelectedItem(characterDetails.get("Class"));
                // Set ability scores into boxes
                strField.setText(characterDetails.get("Strength"));
                dexField.setText(characterDetails.get("Dexterity"));
                conField.setText(characterDetails.get("Constitution"));
                intField.setText(characterDetails.get("Intelligence"));
                wisField.setText(characterDetails.get("Wisdom"));
                chaField.setText(characterDetails.get("Charisma"));

                ancestryFeats1ComboBox.setSelectedItem(characterDetails.get("Ancestry Feat 1"));
                featClass1ComboBox.setSelectedItem(characterDetails.get("Class Feat 1"));
                featClass2ComboBox.setSelectedItem(characterDetails.get("Class Feat 2"));
                featSkill2ComboBox.setSelectedItem(characterDetails.get("Skill Feat 2"));
                featGeneral3ComboBox.setSelectedItem(characterDetails.get("General Feat 3"));
                featClass4ComboBox.setSelectedItem(characterDetails.get("Class Feat 4"));
                featSkill4ComboBox.setSelectedItem(characterDetails.get("Skill Feat 4"));
                ancestryFeats5ComboBox.setSelectedItem(characterDetails.get("Ancestry Feat 5"));
                featClass6ComboBox.setSelectedItem(characterDetails.get("Class Feat 6"));
                featSkill6ComboBox.setSelectedItem(characterDetails.get("Skill Feat 6"));
                featGeneral7ComboBox.setSelectedItem(characterDetails.get("General Feat 7"));
                featClass8ComboBox.setSelectedItem(characterDetails.get("Class Feat 8"));
                featSkill8ComboBox.setSelectedItem(characterDetails.get("Skill Feat 8"));
                ancestryFeats9ComboBox.setSelectedItem(characterDetails.get("Ancestry Feat 9"));
                featClass10ComboBox.setSelectedItem(characterDetails.get("Class Feat 10"));
                featSkill10ComboBox.setSelectedItem(characterDetails.get("Skill Feat 10"));
                featGeneral11ComboBox.setSelectedItem(characterDetails.get("General Feat 11"));
                featClass12ComboBox.setSelectedItem(characterDetails.get("Class Feat 12"));
                featSkill12ComboBox.setSelectedItem(characterDetails.get("Skill Feat 12"));
                ancestryFeats13ComboBox.setSelectedItem(characterDetails.get("Ancestry Feat 13"));
                featClass14ComboBox.setSelectedItem(characterDetails.get("Class Feat 14"));
                featSkill14ComboBox.setSelectedItem(characterDetails.get("Skill Feat 14"));
                featGeneral15ComboBox.setSelectedItem(characterDetails.get("General Feat 15"));
                featClass16ComboBox.setSelectedItem(characterDetails.get("Class Feat 16"));
                featSkill16ComboBox.setSelectedItem(characterDetails.get("Skill Feat 16"));
                featClass18ComboBox.setSelectedItem(characterDetails.get("Class Feat 18"));
                featSkill18ComboBox.setSelectedItem(characterDetails.get("Skill Feat 18"));
                featGeneral19ComboBox.setSelectedItem(characterDetails.get("General Feat 19"));
                featClass20ComboBox.setSelectedItem(characterDetails.get("Class Feat 20"));
                featSkill20ComboBox.setSelectedItem(characterDetails.get("Skill Feat 20"));

                JOptionPane.showMessageDialog(this, "Character loaded successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Error loading character: Invalid file format or file not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    private Map<String, String> loadCharacterFromFile(File file) {
        // Function to read in the character information and pass it back to the loadCharacter function
        // Written by Ryan Janis
        // March 2024
        // Language: Java

        Map<String, String> characterDetails = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(": ");
                if (parts.length == 2) {
                    characterDetails.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            return null;
        }
        return characterDetails;
    }
    private void readClassInfoFromFile(String filename) throws IOException {
        // Function to read in the class information from a specified outside file and which is then used to display based on class
        // Written by Ryan Janis
        // March 2024
        // Language: 2024

        try (BufferedReader reader = new BufferedReader(new FileReader("info/" + filename))) {
            String line;
            String className = null;
            StringBuilder classInfoBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                if (line.endsWith(":")) {
                    // Start of a new class section
                    if (className != null) {
                        // Save the previous class information
                        classInfoMap.put(className, classInfoBuilder.toString());
                    }
                    // Extract class name
                    className = line.substring(0, line.length() - 1);
                    // Reset the class info builder
                    classInfoBuilder.setLength(0);
                } else {
                    // Append class information
                    classInfoBuilder.append(line).append("\n");
                }
            }
            // Save the last class information
            if (className != null) {
                classInfoMap.put(className, classInfoBuilder.toString());
            }
        }
    }
    private void readFeatInfoFromFile(String filename) throws IOException {
        // Function to read in the feat information from a specified outside file and which is then used to display based on class
        // Written by Ryan Janis
        // March 2024
        // Language: 2024

        try (BufferedReader reader = new BufferedReader(new FileReader("info/" + filename))) {
            String line;
            String featName = null;
            StringBuilder featInfoBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                if (line.endsWith(":")) {
                    if (featName != null) {
                        featInfoMap.put(featName, featInfoBuilder.toString());
                    }
                    featName = line.substring(0, line.length() - 1);
                    featInfoBuilder.setLength(0);
                } else {
                    featInfoBuilder.append(line).append("\n");
                }
            }
            if (featName != null) {
                featInfoMap.put(featName, featInfoBuilder.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void readFeatureInfoFromFile(String filename) throws IOException {
        // Function to read in the feature information from a specified outside file and which is then used to display based on class
        // Written by Ryan Janis
        // March 2024
        // Language: 2024

        try (BufferedReader reader = new BufferedReader(new FileReader("info/" + filename))) {
            String line;
            String featureName = null;
            StringBuilder featureInfoBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                if (line.endsWith(":")) {
                    if (featureName != null) {
                        featInfoMap.put(featureName, featureInfoBuilder.toString());
                    }
                    featureName = line.substring(0, line.length() - 1);
                    featureInfoBuilder.setLength(0);
                } else {
                    featureInfoBuilder.append(line).append("\n");
                }
            }
            // Put the last feature's information into the map
            if (featureName != null) {
                featInfoMap.put(featureName, featureInfoBuilder.toString());
            }
        }
    }

    public static void main(String[] args) {
        // Main Function
        // Written by Ryan Janis
        // January 2024
        // Language: Java

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PathfinderCharacterCreator().setVisible(true);
            }
        });
    }
}