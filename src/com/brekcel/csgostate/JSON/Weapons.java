
package com.brekcel.csgostate.JSON;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Weapons {

    @SerializedName("weapon_0")
    @Expose
    private Weapon0 weapon0;
    @SerializedName("weapon_1")
    @Expose
    private Weapon1 weapon1;
    @SerializedName("weapon_2")
    @Expose
    private Weapon2 weapon2;

    /**
     * 
     * @return
     *     The weapon0
     */
    public Weapon0 getWeapon0() {
        return weapon0;
    }

    /**
     * 
     * @param weapon0
     *     The weapon_0
     */
    public void setWeapon0(Weapon0 weapon0) {
        this.weapon0 = weapon0;
    }

    /**
     * 
     * @return
     *     The weapon1
     */
    public Weapon1 getWeapon1() {
        return weapon1;
    }

    /**
     * 
     * @param weapon1
     *     The weapon_1
     */
    public void setWeapon1(Weapon1 weapon1) {
        this.weapon1 = weapon1;
    }

    /**
     * 
     * @return
     *     The weapon2
     */
    public Weapon2 getWeapon2() {
        return weapon2;
    }

    /**
     * 
     * @param weapon2
     *     The weapon_2
     */
    public void setWeapon2(Weapon2 weapon2) {
        this.weapon2 = weapon2;
    }

}
