package com.techlingo.modules.user.service;

import com.techlingo.modules.user.dto.UpdateAvatarRequest;
import com.techlingo.modules.user.dto.UserProfileResponse;

public interface UserService {
        void updateAvatar(UpdateAvatarRequest request);
        UserProfileResponse getProfile();
}
