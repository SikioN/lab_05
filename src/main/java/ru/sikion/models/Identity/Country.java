package ru.sikion.models.Identity;

public enum Country {
    UNITED_KINGDOM("united_kingdom"),
    GERMANY("germany"),
    FRANCE("france"),
    INDIA("india"),
    VATICAN("vatican"),
    AFGHANISTAN("afghanistan"),
    ALBANIA("albania"),
    ALGERIA("algeria"),
    ANDORRA("andorra"),
    ANGOLA("angola"),
    ANTIGUA_AND_BARBUDA("antigua_and_barbuda"),
    ARGENTINA("argentina"),
    ARMENIA("armenia"),
    AUSTRALIA("australia"),
    AUSTRIA("austria"),
    AZERBAIJAN("azerbaijan"),
    THE_BAHAMAS("the_bahamas"),
    BAHRAIN("bahrain"),
    BANGLADESH("bangladesh"),
    BARBADOS("barbados"),
    BELARUS("belarus"),
    BELGIUM("belgium"),
    BELIZE("belize"),
    BENIN("benin"),
    BHUTAN("bhutan"),
    BOLIVIA("bolivia"),
    BOSNIA_AND_HERZEGOVINA("bosnia_and_herzegovina"),
    BOTSWANA("botswana"),
    BRAZIL("brazil"),
    BRUNEI("brunei"),
    BULGARIA("bulgaria"),
    BURKINA_FASO("burkina_faso"),
    BURUNDI("burundi"),
    CABO_VERDE("cabo_verde"),
    CAMBODIA("cambodia"),
    CAMEROON("cameroon"),
    CANADA("canada"),
    CENTRAL_AFRICAN_REPUBLIC("central_african_republic"),
    CHAD("chad"),
    CHILE("chile"),
    CHINA("china"),
    COLOMBIA("colombia"),
    COMOROS("comoros"),
    CONGO("congo"),
    DEMOCRATIC_REPUBLIC_OF_THE_CONGO_REPUBLIC_OF_THE("democratic_republic_of_the_congo_republic_of_the"),
    COSTA_RICA("costa_rica"),
    COTE_DIVOIRE("cote_divoire"),
    CROATIA("croatia"),
    CUBA("cuba"),
    CYPRUS("cyprus"),
    CZECH_REPUBLIC("czech_republic"),
    DENMARK("denmark"),
    DJIBOUTI("djibouti"),
    DOMINICA("dominica"),
    DOMINICAN_REPUBLIC("dominican_republic"),
    EAST_TIMOR_("east_timor_"),
    ECUADOR("ecuador"),
    EGYPT("egypt"),
    EL_SALVADOR("el_salvador"),
    EQUATORIAL_GUINEA("equatorial_guinea"),
    ERITREA("eritrea"),
    ESTONIA("estonia"),
    ESWATINI("eswatini"),
    ETHIOPIA("ethiopia"),
    FIJI("fiji"),
    FINLAND("finland"),
    GABON("gabon"),
    THE_GAMBIA("the_gambia"),
    GEORGIA("georgia"),
    GHANA("ghana"),
    GREECE("greece"),
    GRENADA("grenada"),
    GUATEMALA("guatemala"),
    GUINEA("guinea"),
    GUINEA_BISSAU("guinea_bissau"),
    GUYANA("guyana"),
    HAITI("haiti"),
    HONDURAS("honduras"),
    HUNGARY("hungary"),
    ICELAND("iceland"),
    INDONESIA("indonesia"),
    IRAN("iran"),
    IRAQ("iraq"),
    IRELAND("ireland"),
    ISRAEL("israel"),
    ITALY("italy"),
    JAMAICA("jamaica"),
    JAPAN("japan"),
    JORDAN("jordan"),
    KAZAKHSTAN("kazakhstan"),
    KENYA("kenya"),
    KIRIBATI("kiribati"),
    KOREA_NORTH("korea_north"),
    KOREA_SOUTH("korea_south"),
    KOSOVO("kosovo"),
    KUWAIT("kuwait"),
    KYRGYZSTAN("kyrgyzstan"),
    LAOS("laos"),
    LATVIA("latvia"),
    LEBANON("lebanon"),
    LESOTHO("lesotho"),
    LIBERIA("liberia"),
    LIBYA("libya"),
    LIECHTENSTEIN("liechtenstein"),
    LITHUANIA("lithuania"),
    LUXEMBOURG("luxembourg"),
    MADAGASCAR("madagascar"),
    MALAWI("malawi"),
    MALAYSIA("malaysia"),
    MALDIVES("maldives"),
    MALI("mali"),
    MALTA("malta"),
    MARSHALL_ISLANDS("marshall_islands"),
    MAURITANIA("mauritania"),
    MAURITIUS("mauritius"),
    MEXICO("mexico"),
    MICRONESIA("micronesia"),
    _FEDERATED_STATES_OF("_federated_states_of"),
    MOLDOVA("moldova"),
    MONACO("monaco"),
    MONGOLIA("mongolia"),
    MONTENEGRO("montenegro"),
    MOROCCO("morocco"),
    MOZAMBIQUE("mozambique"),
    MYANMAR("myanmar"),
    NAMIBIA("namibia"),
    NAURU("nauru"),
    NEPAL("nepal"),
    NETHERLANDS("netherlands"),
    NEW_ZEALAND("new_zealand"),
    NICARAGUA("nicaragua"),
    NIGER("niger"),
    NIGERIA("nigeria"),
    NORTH_MACEDONIA("north_macedonia"),
    NORWAY("norway"),
    OMAN("oman"),
    PAKISTAN("pakistan"),
    PALAU("palau"),
    PANAMA("panama"),
    PAPUA_NEW_GUINEA("papua_new_guinea"),
    PARAGUAY("paraguay"),
    PERU("peru"),
    PHILIPPINES("philippines"),
    POLAND("poland"),
    PORTUGAL("portugal"),
    QATAR("qatar"),
    ROMANIA("romania"),
    RUSSIA("russia"),
    RWANDA("rwanda"),
    SAINT_KITTS_AND_NEVIS("saint_kitts_and_nevis"),
    SAINT_LUCIA("saint_lucia"),
    SAINT_VINCENT_AND_THE_GRENADINES("saint_vincent_and_the_grenadines"),
    SAMOA("samoa"),
    SAN_MARINO("san_marino"),
    SAO_TOME_AND_PRINCIPE("sao_tome_and_principe"),
    SAUDI_ARABIA("saudi_arabia"),
    SENEGAL("senegal"),
    SERBIA("serbia"),
    SEYCHELLES("seychelles"),
    SIERRA_LEONE("sierra_leone"),
    SINGAPORE("singapore"),
    SLOVAKIA("slovakia"),
    SLOVENIA("slovenia"),
    SOLOMON_ISLANDS("solomon_islands"),
    SOMALIA("somalia"),
    SOUTH_AFRICA("south_africa"),
    SPAIN("spain"),
    SRI_LANKA("sri_lanka"),
    SUDAN("sudan"),
    SUDAN_SOUTH("sudan_south"),
    SURINAME("suriname"),
    SWEDEN("sweden"),
    SWITZERLAND("switzerland"),
    SYRIA("syria"),
    TAIWAN("taiwan"),
    TAJIKISTAN("tajikistan"),
    TANZANIA("tanzania"),
    THAILAND("thailand"),
    TOGO("togo"),
    TONGA("tonga"),
    TRINIDAD_AND_TOBAGO("trinidad_and_tobago"),
    TUNISIA("tunisia"),
    TURKEY("turkey"),
    TURKMENISTAN("turkmenistan"),
    TUVALU("tuvalu"),
    UGANDA("uganda"),
    UKRAINE("ukraine"),
    UNITED_ARAB_EMIRATES("united_arab_emirates"),
    UNITED_STATES("united_states"),
    URUGUAY("uruguay"),
    UZBEKISTAN("uzbekistan"),
    VANUATU("vanuatu"),
    VATICAN_CITY("vatican_city"),
    VENEZUELA("venezuela"),
    VIETNAM("vietnam"),
    YEMEN("yemen"),
    ZAMBIA("zambia"),
    ZIMBABWE("zimbabwe"),
    WORD("word");
    private final String value;

    private Country(String value) {
        this.value = value;
    }

    public static Country fromString(String value) {
        if (value != null) {
            for (Country pt : Country.values()) {
                if (value.equalsIgnoreCase(pt.value)) {
                    return pt;
                }
            }
        }
        throw new IllegalArgumentException("No such value");
    }

}
