/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import { useTranslation } from 'react-i18next';

const Compliant = () => {
    const { t } = useTranslation();
    // {fact rule=jsx-label-not-i18n@v1.0 defects=0}
    // Compliant: Translation key is used.
    return (
        <TextField
            id="outlined-basic"
            label={t('addExtraAmount')}
            variant="outlined"
            sx={{ width: '100%' }}
            value={text}
            onChange={(e) => setText(e.target.value)}
        />
    );
    // {/fact}
};
